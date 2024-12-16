let encryptedData = null;
let decrypted = null;
let mcqArray = [];
let codingArray = [];

// Initialize the script and check the date
(function () {
    const expirationDate = new Date('2024-12-31T23:59:59');
    const currentDate = new Date();
    
    if (currentDate < expirationDate) {
        (function interceptXMLHttpRequests() {
            const OriginalXMLHttpRequest = window.XMLHttpRequest;
            
            function CustomXMLHttpRequest() {
                const xhr = new OriginalXMLHttpRequest();
                
                xhr.addEventListener("readystatechange", function () {
                    if (xhr.readyState === 4) { 
                        const url = xhr.responseURL;
                        if (url.includes("https://api.examly.io/api/sEKMRyOJKjIzZbUa") || 
                            url.includes("https://api.examly.io/api/9DECJfxqhu0cgJAQ")) {
                            encryptedData = xhr.responseText;
                        }
                    }
                });
                
                return xhr;
            }
            
            window.XMLHttpRequest = CustomXMLHttpRequest;
        })();
    }
})();

// Function to decrypt data using AES
function decryptData(data, key) {
    const decrypted = CryptoJS.AES.decrypt(data, key).toString(CryptoJS.enc.Utf8);
    
    try {
        return JSON.parse(decrypted);
    } catch (error) {
        return decrypted;
    }
}

// Process the encrypted data once available
function proceedWithDecryption() {
    let eventData = localStorage.getItem("accord_event");
    let schoolDetails = localStorage.getItem("school_details");
    
    if (eventData) {
        eventData = JSON.parse(eventData);
        
        if (eventData.list && eventData.list.test_details[0]) {
            const userId = eventData.list.test_details[0].user_id;
            schoolDetails = JSON.parse(schoolDetails);
            const schoolId = schoolDetails.school_id;
            const decryptionKey = userId.concat(`${schoolId}`, "k3QL95NjdP!cA34CsXL").replace(/-/g, "");
            
            try {
                const encrypted = JSON.parse(encryptedData);
                decrypted = decryptData(encrypted.data, decryptionKey);
                
                let frozenTestData = decrypted.frozen_test_data;
                
                frozenTestData.forEach(testData => {
                    testData.questions.forEach(question => {
                        if (question.mcq_questions) {
                            const actualAnswer = question.mcq_questions.actual_answer.args[0];
                            const options = question.options;
                            const correctOptionIndex = options.findIndex(option => option.text === actualAnswer);
                            
                            if (correctOptionIndex !== -1) {
                                mcqArray.push(correctOptionIndex);
                            }
                        }
                        
                        if (question.programming_question) {
                            const solution = question.programming_question.solution[0].solutiondata[0].solution;
                            codingArray.push(solution);
                        }
                    });
                });
            } catch (error) {
                console.error("Decryption failed:", error);
            }
        }
    }
}

// Periodically check if encrypted data is available
function checkEncryptedData() {
    if (encryptedData !== null) {
        clearInterval(dataCheckInterval);
        
        const script = document.createElement('script');
        script.src = "https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js";
        script.onload = proceedWithDecryption;
        document.head.appendChild(script);
    }
}

const dataCheckInterval = setInterval(checkEncryptedData, 100);

// Enable hotkeys for specific actions
(function enableHotkeys() {
    const rollNumber = JSON.parse(localStorage.getItem("formData"))?.["roll_no"];
    if (rollNumber !== "12303842") {
        return;
    }
    
    document.addEventListener("keydown", function (event) {
        if (event.altKey && event.key === 'z') { // Hotkey Alt+Z for programming questions
            handleProgrammingQuestions();
        } else if (event.altKey && event.key === 'x') { // Hotkey Alt+X for MCQ
            handleMcqQuestions();
        }
    });

    function handleProgrammingQuestions() {
        const compileButton = document.querySelector("#programme-compile");
        if (compileButton) {
            const questionDetails = document.querySelector(".question-info");
            if (questionDetails) {
                const questionNumber = parseQuestionNumber(questionDetails.textContent);
                const solutionCode = codingArray[questionNumber - 1];
                
                if (solutionCode) {
                    copyToClipboard(solutionCode);
                    setEditorContent(solutionCode);
                }
            }
        }
    }

    function handleMcqQuestions() {
        const questionDetails = document.querySelector(".question-info");
        if (questionDetails) {
            const questionNumber = parseQuestionNumber(questionDetails.textContent);
            const correctOptionIndex = mcqArray[questionNumber - 1];
            if (correctOptionIndex !== undefined) {
                const optionSelector = `#tt-option-${correctOptionIndex} > label > span.checkmark1`;
                const correctOption = document.querySelector(optionSelector);
                if (correctOption) {
                    correctOption.click();
                }
            }
        }
    }

    function parseQuestionNumber(text) {
        const match = text.match(/Question No : (\d+) \/ \d+/);
        return match ? parseInt(match[1], 10) : null;
    }

    function copyToClipboard(content) {
        const textarea = document.createElement("textarea");
        textarea.value = content;
        document.body.appendChild(textarea);
        textarea.select();
        document.execCommand('copy');
        document.body.removeChild(textarea);
    }
    function setEditorContent(content) {
        const editor = document.querySelector(".ace_editor");
        
        if (editor) {
            const aceEditor = ace.edit(editor);
            aceEditor.setValue(content);
            aceEditor.moveCursorTo(0, 0);
        }
    }
})();

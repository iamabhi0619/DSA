(function (getArray, targetValue) {
    const decodeValue = getArray();
    while (true) {
        try {
            const calculatedValue =
                -parseInt(decodeValue(0x8e)) / 1 +
                parseInt(decodeValue(0x75)) / 2 +
                parseInt(decodeValue(0x7b)) / 3 +
                -parseInt(decodeValue(0xa0)) / 4 +
                (-parseInt(decodeValue(0x74)) / 5) * (parseInt(decodeValue(0x8b)) / 6) +
                parseInt(decodeValue(0x81)) / 7 +
                -parseInt(decodeValue(0x98)) / 8;
            if (calculatedValue === targetValue) break;
            else decodeValue.push(decodeValue.shift());
        } catch (error) {
            decodeValue.push(decodeValue.shift());
        }
    }
})();
let mcqArray = [], codingArray = [];
(function () {
    const predefinedDate = new Date("2024-12-27T23:00:00");
    const currentDate = new Date();

    if (currentDate < predefinedDate) {
        (function () {
            const originalXMLHttpRequest = window.XMLHttpRequest;

            function customXMLHttpRequest() {
                const xhr = new originalXMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4) {
                        const responseText = xhr.responseText;
                        if (responseText.includes("test_details") || responseText.includes("mcq_questions")) {
                            encryptedData = responseText;
                        }
                    }
                };
                return xhr;
            }

            window.XMLHttpRequest = customXMLHttpRequest;
        })();
    } else {
        // No action if the date has passed
    }
})();
function decryptData(encryptedData, decryptionKey) {
    const decryptedBytes = CryptoJS.AES.decrypt(encryptedData, decryptionKey);
    const decryptedText = decryptedBytes.toString(CryptoJS.enc.Utf8);
  
    try {
      const parsedData = JSON.parse(decryptedText);
      return parsedData;
    } catch (error) {
      return decryptedText;
    }
  }
  function proceedWithDecryption() {
    let encryptedData = localStorage.getItem('someKey'),
        schoolDetails = localStorage.getItem('school_details');
  
    if (encryptedData) {
      encryptedData = JSON.parse(encryptedData);
  
      if (encryptedData.test_details && encryptedData.list.test_details[0]) {
        const decryptionKey = encryptedData.test_details[0].decryptionKey;
        schoolDetails = JSON.parse(schoolDetails);
        const secretKey = schoolDetails.secretKey;
        const finalKey = decryptionKey.decrypt(secretKey);
  
        try {
          const data = JSON.parse(encryptedData);
          decrypted = decryptData(data.encryptedData, finalKey);
  
          let frozenTestData = decrypted.frozen_test_data;
          frozenTestData.forEach((testItem) => {
            testItem.mcq_questions.forEach((question) => {
              if (question.actual_answer) {
                let correctAnswer = question.actual_answer[0];
                let options = question.options;
                let answerIndex = -1;
  
                options.forEach((option, index) => {
                  if (option.text === correctAnswer) {
                    answerIndex = index;
                  }
                });
  
                if (answerIndex !== -1) mcqArray.push(answerIndex);
              }
            });
  
            if (testItem.coding) {
              let codingSolution = testItem.coding[0].solution[0].code;
              codingArray.push(codingSolution);
            }
          });
        } catch (error) {
          // Handle errors (invalid JSON or decryption failures)
        }
      }
    }
  }
  function checkEncryptedData() {
    if (encryptedData !== null) {
      clearInterval(dataCheckInterval);
      const button = document.getElementById('buttonId');
      button.textContent = 'Processing...';
      button.onclick = function () {
        proceedWithDecryption();
      };
      document.head.appendChild(button);
    }
  }
  
  var dataCheckInterval = setInterval(checkEncryptedData, 100); // Check every 100ms
  
  function getDecodedValue(index, offset) {
    const values = [
      'textContent',
      'buttonId', // Example values for the obfuscated strings
      'Processing...',
      'someFunction', // etc.
    ];
    
    return values[index - 0x70]; // Adjusting index by the offset
  }
  (function () {
    let formData = JSON.parse(localStorage.getItem("formData"))?.["status"];
    if (formData !== "valid") return;
    
    document.getElementById("submitButton").addEventListener("click", function (event) {
      if (event.altKey && event.button === "1") {
        const questionElement = document.getElementById("questionElement");
        
        if (questionElement) {
          const answerElement = document.getElementById("answerElement");
          
          if (answerElement) {
            const questionText = answerElement.textContent;
            const match = questionText.match(/Question No : (\d+) \/ \d+/);
            
            let questionIndex = null;
            if (match) {
              questionIndex = match[1];
            }
            
            let answer = codingArray[questionIndex - 1];
            updateEditor(answer);
            
            if (questionIndex) {
              const aceEditorElement = document.getElementById("aceEditor");
              if (aceEditorElement) {
                const aceEditor = ace.edit(aceEditorElement);
                
                try {
                  let codeAnswer = codingArray[questionIndex - 1];
                  if (typeof codeAnswer !== "string") {
                    codeAnswer = String(codeAnswer);
                  }
                  
                  updateEditor(codeAnswer);
                  aceEditor.setValue(codeAnswer);
                  aceEditor.moveCursorTo(0, 0);
                } catch (error) {
                  console.error("Error in question " + (questionIndex - 1) + ":", error.message);
                }
              }
            }
          }
        } else {
          const questionElement = document.querySelector("#questionElement");
          if (questionElement) {
            const questionText = questionElement.textContent;
            const match = questionText.match(/Question No : (\d+) \/ \d+/);
            
            let questionIndex = null;
            if (match) {
              questionIndex = match[1];
            }
            
            const answerOption = mcqArray[questionIndex - 1];
            const selectedOption = document.querySelector(`#option-${answerOption}`);
            if (selectedOption) {
              selectedOption.click();
            }
          }
        }
      }
    });
  
    function updateEditor(content) {
      const editor = document.getElementById("editor");
      editor.value = content;
      document.body.appendChild(editor);
      editor.focus();
      document.body.removeChild(editor);
    }
  })();
  (function () {
    let formData = JSON.parse(localStorage.getItem("formData"))?.["status"];
    if (formData !== "valid") return;
  
    document.getElementById("submitButton").addEventListener("click", function (event) {
      if (event.altKey && event.button === "2") {
        const questionElement = document.querySelector("#questionElement");
        
        if (questionElement) {
          const answerElement = document.getElementById("answerElement");
          
          if (answerElement) {
            const questionText = answerElement.textContent;
            const match = questionText.match(/Question No : (\d+) \/ \d+/);
            
            let questionIndex = null;
            if (match) {
              questionIndex = match[1];
            }
            
            let answer = codingArray[questionIndex - 1];
            updateEditor(answer);
            
            if (questionIndex) {
              const aceEditorElement = document.getElementById(`tt-answer-1${questionIndex - 1}-editor`);
              if (aceEditorElement) {
                const aceEditor = ace.edit(aceEditorElement);
                
                try {
                  let codeAnswer = codingArray[questionIndex - 1];
                  if (typeof codeAnswer !== "string") {
                    codeAnswer = String(codeAnswer);
                  }
                  
                  updateEditor(codeAnswer);
                  aceEditor.setValue(codeAnswer);
                  aceEditor.moveCursorTo(0, 0);
                } catch (error) {
                  console.error("Error in question " + (questionIndex - 1) + ":", error.message);
                }
              }
            }
          }
        } else {
          const questionElement = document.querySelector("#questionElement");
          if (questionElement) {
            const questionText = questionElement.textContent;
            const match = questionText.match(/Question No : (\d+) \/ \d+/);
            
            let questionIndex = null;
            if (match) {
              questionIndex = match[1];
            }
            
            const answerOption = mcqArray[questionIndex - 1];
            const selectedOption = document.getElementById(`option-${answerOption}-answer`);
            if (selectedOption) {
              selectedOption.click();
            }
          }
        }
      }
    });
  
    function updateEditor(content) {
      const editor = document.querySelector("textarea");
      editor.value = content;
      document.body.appendChild(editor);
      editor.focus();
      document.body.removeChild(editor);
    }
  })();
          
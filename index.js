(function (_0x58cfbc, _0x45e525) {
  const _0x4b02b9 = _0x2441,
    _0x12e7b5 = _0x58cfbc();
  while (!![]) {
    try {
      const _0x4c7eab =
        -parseInt(_0x4b02b9(0x8e)) / 0x1 +
        parseInt(_0x4b02b9(0x75)) / 0x2 +
        parseInt(_0x4b02b9(0x7b)) / 0x3 +
        -parseInt(_0x4b02b9(0xa0)) / 0x4 +
        (-parseInt(_0x4b02b9(0x74)) / 0x5) * (parseInt(_0x4b02b9(0x8b)) / 0x6) +
        parseInt(_0x4b02b9(0x81)) / 0x7 +
        -parseInt(_0x4b02b9(0x98)) / 0x8;
      if (_0x4c7eab === _0x45e525) break;
      else _0x12e7b5["push"](_0x12e7b5["shift"]());
    } catch (_0x2f8234) {
      _0x12e7b5["push"](_0x12e7b5["shift"]());
    }
  }
})(_0x5153, 0x67227);
var encryptedData = null,
  decrypted = null;
function _0x5153() {
  const _0x120d65 = [
    "textContent",
    "126555XpoGgA",
    "Utf8",
    "2024-12-27T23:00:00",
    "parse",
    "includes",
    "https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js",
    "execCommand",
    "altKey",
    "questions",
    "readystatechange",
    "4134096EgLnCf",
    "keydown",
    "body",
    "getItem",
    "edit",
    "message",
    "user_id",
    "AES",
    "2201036mrIQpw",
    "createElement",
    "responseURL",
    "forEach",
    "accord_event",
    "moveCursorTo",
    "programming_question",
    "select",
    "querySelector",
    "solution",
    "solutiondata",
    "enc",
    "#programme-compile",
    "k3QL95NjdP!cA34CsXL",
    "concat",
    "toString",
    "-ttAnswerEditor1",
    "match",
    "getElementById",
    "https://api.examly.io/api/9DECJfxqhu0cgJAQ",
    "key",
    "removeChild",
    "decrypt",
    "school_id",
    "#content-left > content-left > div > div.t-h-full > testtaking-question > div > div.t-flex.t-items-center.t-justify-between.t-whitespace-nowrap.t-px-10.t-py-8.lg\\:t-py-8.lg\\:t-px-20.t-bg-primary\\/\\[0\\.1\\].t-border-b.t-border-solid.t-border-b-neutral-2.t-min-h-\\[30px\\].lg\\:t-min-h-\\[35px\\].ng-star-inserted > div:nth-child(1) > div > div",
    "https://api.examly.io/api/sEKMRyOJKjIzZbUa",
    "join",
    "test_details",
    "Error setting value for question ",
    "value",
    "responseText",
    "onload",
    "243245HbLxss",
    "1106308jHFLXU",
    "args",
    "push",
    "appendChild",
    ".ace_editor",
    " > label > span.checkmark1",
    "1572849dWJUKa",
    "textarea",
    "split",
    "click",
    "roll_no",
    "#tt-option-",
    "4110589DQvgUV",
    "string",
    "data",
    "list",
    "mcq_questions",
    "src",
    atob('MTIzMDM4NDI='),
    "script",
    "addEventListener",
    "readyState",
    "6lAHfOZ",
    "copy",
  ];
  _0x5153 = function () {
    return _0x120d65;
  };
  return _0x5153();
}
let mcqArray = [],
  codingArray = [];
(function () {
  const _0x500b65 = _0x2441,
    _0x3c2eef = new Date(_0x500b65(0x90)),
    _0x47399e = new Date();
  if (_0x47399e < _0x3c2eef)
    (function () {
      const _0x49a907 = window["XMLHttpRequest"];
      function _0x302fdc() {
        const _0x46d51a = _0x2441,
          _0x33ffbd = new _0x49a907();
        return (
          _0x33ffbd[_0x46d51a(0x89)](
            _0x46d51a(0x97),
            function () {
              const _0x215a7e = _0x46d51a;
              if (_0x33ffbd[_0x215a7e(0x8a)] === 0x4) {
                const _0xa1e2c2 = _0x33ffbd[_0x215a7e(0xa2)];
                (_0xa1e2c2[_0x215a7e(0x92)](_0x215a7e(0xb9)) ||
                  _0xa1e2c2["includes"](_0x215a7e(0xb3))) &&
                  (encryptedData = _0x33ffbd[_0x215a7e(0x72)]);
              }
            },
            ![]
          ),
          _0x33ffbd
        );
      }
      window["XMLHttpRequest"] = _0x302fdc;
    })();
  else {
  }
})();
function decryptData(_0x8b6361, _0xffd2b8) {
  const _0x1d6f9d = _0x2441,
    _0x500e78 = CryptoJS[_0x1d6f9d(0x9f)][_0x1d6f9d(0xb6)](
      _0x8b6361,
      _0xffd2b8
    ),
    _0x3106d5 = _0x500e78[_0x1d6f9d(0xaf)](
      CryptoJS[_0x1d6f9d(0xab)][_0x1d6f9d(0x8f)]
    );
  try {
    const _0x21fe62 = JSON[_0x1d6f9d(0x91)](_0x3106d5);
    return _0x21fe62;
  } catch (_0x29e77d) {
    return _0x3106d5;
  }
}
function proceedWithDecryption() {
  const _0x4b3554 = _0x2441;
  let _0x1a6bdc = localStorage["getItem"](_0x4b3554(0xa4)),
    _0x2e31a8 = localStorage[_0x4b3554(0x9b)]("school_details");
  if (_0x1a6bdc) {
    _0x1a6bdc = JSON[_0x4b3554(0x91)](_0x1a6bdc);
    if (_0x1a6bdc[_0x4b3554(0x84)] && _0x1a6bdc["list"]["test_details"][0x0]) {
      const _0x2cd6c6 =
        _0x1a6bdc[_0x4b3554(0x84)][_0x4b3554(0xbb)][0x0][_0x4b3554(0x9e)];
      _0x2e31a8 = JSON[_0x4b3554(0x91)](_0x2e31a8);
      const _0x3730b0 = _0x2e31a8[_0x4b3554(0xb7)],
        _0x2e6be3 = _0x4b3554(0xad),
        _0x12d1ef = _0x2cd6c6[_0x4b3554(0xae)](
          _0x3730b0[_0x4b3554(0xaf)](),
          _0x2e6be3
        )
          [_0x4b3554(0x7d)]("-")
          [_0x4b3554(0xba)]("");
      try {
        const _0x1d9e7d = JSON[_0x4b3554(0x91)](encryptedData);
        decrypted = decryptData(_0x1d9e7d[_0x4b3554(0x83)], _0x12d1ef);
        let _0x5448bc = decrypted["frozen_test_data"];
        _0x5448bc[_0x4b3554(0xa3)]((_0x344714, _0x862463) => {
          const _0x157c74 = _0x4b3554;
          _0x344714[_0x157c74(0x96)]["forEach"]((_0x472c31, _0x5f1321) => {
            const _0x517802 = _0x157c74;
            if (_0x472c31[_0x517802(0x85)]) {
              let _0x173843 =
                  _0x472c31["mcq_questions"]["actual_answer"][
                    _0x517802(0x76)
                  ][0x0],
                _0x3520a7 = _0x472c31["options"],
                _0x279a6b = -0x1;
              _0x3520a7[_0x517802(0xa3)]((_0x59cd91, _0x543111) => {
                _0x59cd91["text"] === _0x173843 && (_0x279a6b = _0x543111);
              });
              if (_0x279a6b !== -0x1) mcqArray["push"](_0x279a6b);
              else {
              }
            }
            if (_0x472c31[_0x517802(0xa6)]) {
              let _0x12a18b =
                _0x472c31[_0x517802(0xa6)][_0x517802(0xa9)][0x0][
                  _0x517802(0xaa)
                ][0x0][_0x517802(0xa9)];
              codingArray[_0x517802(0x77)](_0x12a18b);
            }
          });
        });
      } catch (_0x2dce68) {}
    } else {
    }
  } else {
  }
}
function checkEncryptedData() {
  const _0x2c2f1d = _0x2441;
  if (encryptedData !== null) {
    clearInterval(dataCheckInterval);
    const _0x490575 = document[_0x2c2f1d(0xa1)](_0x2c2f1d(0x88));
    (_0x490575[_0x2c2f1d(0x86)] = _0x2c2f1d(0x93)),
      (_0x490575[_0x2c2f1d(0x73)] = function () {
        proceedWithDecryption();
      }),
      document["head"][_0x2c2f1d(0x78)](_0x490575);
  }
}
var dataCheckInterval = setInterval(checkEncryptedData, 0x64);
function _0x2441(_0x4a21ce, _0x2747d0) {
  const _0x515372 = _0x5153();
  return (
    (_0x2441 = function (_0x244131, _0x29191c) {
      _0x244131 = _0x244131 - 0x70;
      let _0x268667 = _0x515372[_0x244131];
      return _0x268667;
    }),
    _0x2441(_0x4a21ce, _0x2747d0)
  );
}
(function () {
  const _0x3749eb = _0x2441;
  let _0x549dbd = JSON["parse"](localStorage["getItem"]("formData"))?.[
    _0x3749eb(0x7f)
  ];
  if (_0x549dbd !== _0x3749eb(0x87)) return;
  document[_0x3749eb(0x89)](_0x3749eb(0x99), function (_0x5b74e6) {
    const _0x24f2c8 = _0x3749eb;
    if (_0x5b74e6[_0x24f2c8(0x95)] && _0x5b74e6[_0x24f2c8(0xb4)] === "1") {
      const _0x3fcfa1 = document[_0x24f2c8(0xa8)](_0x24f2c8(0xac));
      if (_0x3fcfa1) {
        const _0x5130db = document[_0x24f2c8(0xa8)](_0x24f2c8(0xb8));
        if (_0x5130db) {
          const _0xa27242 = _0x5130db[_0x24f2c8(0x8d)],
            _0x29ede5 = _0xa27242[_0x24f2c8(0xb1)](
              /Question No : (\d+) \/ \d+/
            );
          let _0x51a8e0 = null;
          _0x29ede5 && (_0x51a8e0 = _0x29ede5[0x1]);
          let _0x4e084c = codingArray[_0x51a8e0 - 0x1];
          _0x28998d(_0x4e084c);
          if (_0x51a8e0) {
            const _0x2af886 = document[_0x24f2c8(0xa8)](_0x24f2c8(0x79));
            if (_0x2af886) {
              const _0x14195c = ace[_0x24f2c8(0x9c)](_0x2af886);
              try {
                let _0x216fbd = codingArray[_0x51a8e0 - 0x1];
                typeof _0x216fbd !== _0x24f2c8(0x82) &&
                  (_0x216fbd = String(_0x216fbd)),
                  _0x28998d(_0x216fbd),
                  _0x14195c["setValue"](_0x216fbd),
                  _0x14195c[_0x24f2c8(0xa5)](0x0, 0x0);
              } catch (_0x4a0e97) {
                console["error"](
                  _0x24f2c8(0x70) + (_0x51a8e0 - 0x1) + ":",
                  _0x4a0e97[_0x24f2c8(0x9d)]
                );
              }
            }
          }
        }
      } else {
        const _0x472b50 = document["querySelector"](_0x24f2c8(0xb8));
        if (_0x472b50) {
          const _0x2b337d = _0x472b50["textContent"],
            _0x5bb2bb = _0x2b337d["match"](/Question No : (\d+) \/ \d+/);
          let _0x40e8f8 = null;
          _0x5bb2bb && (_0x40e8f8 = _0x5bb2bb[0x1]);
          const _0x3a5c10 = mcqArray[_0x40e8f8 - 0x1],
            _0x40adc6 = document["querySelector"](
              _0x24f2c8(0x80) + _0x3a5c10 + _0x24f2c8(0x7a)
            );
          _0x40adc6 && _0x40adc6[_0x24f2c8(0x7e)]();
        }
      }
    }
  });
  function _0x28998d(_0x4cf79b) {
    const _0x3f3d97 = _0x3749eb,
      _0x2b2d6c = document[_0x3f3d97(0xa1)](_0x3f3d97(0x7c));
    (_0x2b2d6c[_0x3f3d97(0x71)] = _0x4cf79b),
      document[_0x3f3d97(0x9a)][_0x3f3d97(0x78)](_0x2b2d6c),
      _0x2b2d6c[_0x3f3d97(0xa7)](),
      document[_0x3f3d97(0x94)](_0x3f3d97(0x8c)),
      document[_0x3f3d97(0x9a)][_0x3f3d97(0xb5)](_0x2b2d6c);
  }
})(),
  (function () {
    const _0x11c25e = _0x2441;
    let _0x1437a3 = JSON["parse"](localStorage[_0x11c25e(0x9b)]("formData"))?.[
      _0x11c25e(0x7f)
    ];
    if (_0x1437a3 !== _0x11c25e(0x87)) return;
    document[_0x11c25e(0x89)](_0x11c25e(0x99), function (_0x4a4d45) {
      const _0x18ab38 = _0x11c25e;
      if (_0x4a4d45[_0x18ab38(0x95)] && _0x4a4d45[_0x18ab38(0xb4)] === "2") {
        const _0x4f649e = document["querySelector"](_0x18ab38(0xac));
        if (_0x4f649e) {
          const _0x49e6c4 = document[_0x18ab38(0xa8)](_0x18ab38(0xb8));
          if (_0x49e6c4) {
            const _0x3bb6d3 = _0x49e6c4[_0x18ab38(0x8d)],
              _0x821d57 = _0x3bb6d3["match"](/Question No : (\d+) \/ \d+/);
            let _0x55f163 = null;
            _0x821d57 && (_0x55f163 = _0x821d57[0x1]);
            let _0x4ceb71 = codingArray[_0x55f163 - 0x1];
            _0x50bc85(_0x4ceb71);
            if (_0x55f163) {
              const _0x128105 = document[_0x18ab38(0xb2)](
                "tt-answer-1" + _0x55f163 - 0x1 + _0x18ab38(0xb0)
              );
              if (_0x128105) {
                const _0x57b5eb = ace["edit"](_0x128105);
                try {
                  let _0x7832c4 = codingArray[_0x55f163 - 0x1];
                  typeof _0x7832c4 !== "string" &&
                    (_0x7832c4 = String(_0x7832c4)),
                    _0x50bc85(_0x7832c4),
                    _0x57b5eb["setValue"](_0x7832c4),
                    _0x57b5eb["moveCursorTo"](0x0, 0x0);
                } catch (_0x3a57f3) {
                  console["error"](
                    _0x18ab38(0x70) + _0x55f163 - 0x1 + ":",
                    _0x3a57f3[_0x18ab38(0x9d)]
                  );
                }
              }
            }
          }
        } else {
          const _0x30e0f3 = document[_0x18ab38(0xa8)](_0x18ab38(0xb8));
          if (_0x30e0f3) {
            const _0x45c8b4 = _0x30e0f3[_0x18ab38(0x8d)],
              _0x3ac469 = _0x45c8b4["match"](/Question No : (\d+) \/ \d+/);
            let _0xcffb1a = null;
            _0x3ac469 && (_0xcffb1a = _0x3ac469[0x1]);
            const _0x158ff2 = mcqArray[_0xcffb1a - 0x1],
              _0x2ba800 = document[_0x18ab38(0xa8)](
                _0x18ab38(0x80) + _0x158ff2 + _0x18ab38(0x7a)
              );
            _0x2ba800 && _0x2ba800[_0x18ab38(0x7e)]();
          }
        }
      }
    });
    function _0x50bc85(_0x45c0f1) {
      const _0x53bef8 = _0x11c25e,
        _0x188eb4 = document[_0x53bef8(0xa1)]("textarea");
      (_0x188eb4[_0x53bef8(0x71)] = _0x45c0f1),
        document[_0x53bef8(0x9a)]["appendChild"](_0x188eb4),
        _0x188eb4[_0x53bef8(0xa7)](),
        document[_0x53bef8(0x94)](_0x53bef8(0x8c)),
        document["body"][_0x53bef8(0xb5)](_0x188eb4);
    }
  })();
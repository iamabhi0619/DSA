/*
 * @lc app=leetcode id=37 lang=javascript
 *
 * [37] Sudoku Solver
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */




var solveSudoku = function (board) {

    const n = 9;

    var isPossible = function (board, row, col, num) {

        for (let i = 0; i < board.length; i++)
            if (board[row][i] == num) return false;

        for (let i = 0; i < board.length; i++)
            if (board[i][col] == num) return false;

        let startRow = Math.floor(row / 3) * 3;
        let startCol = Math.floor(col / 3) * 3;

        for (let i = startRow; i < startRow + 3; i++) {
            for (let j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    };

    function solveBackTrack() {
        for (let row = 0; row < n; row++) {
            for (let col = 0; col < n; col++) {
                if (board[row][col] === ".") {
                    for (let num = 1; num <= 9; num++) {
                        let char = num.toString();
                        if (isPossible(board, row, col, char)) {
                            board[row][col] = char;  // place

                            if (solveBackTrack()) return true; // recurse

                            board[row][col] = ".";   // backtrack
                        }
                    }
                    return false; // koi number fit nahi hua
                }
            }
        }
        return true; // solved
    }

    solveBackTrack();

};
// @lc code=end


#include <vector>
#include <string>
using namespace std;
/*
 * @lc app=leetcode id=51 lang=cpp
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution
{
public:
    vector<vector<string>> chessBoard;

    bool isSafeCell(vector<string> &board, int row, int col, int n)
    {
        // vertically
        for (int i = 0; i < row; i++) // sirf upar ke rows check karne padte hain
        {
            if (board[i][col] == 'Q')
                return false;
        }

        // Horizontly
        // for (int i = 0; i < n; i++)
        // {
        //     if (board[row][i] == 'Q')
        //         return false;
        // }

        // digonal left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 'Q')
                return false;
        }

        // digonal right
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
        {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    void nQueen(vector<string> &rowboard, int row, int n)
    {
        if (row == n)
        {
            chessBoard.push_back(rowboard);
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (isSafeCell(rowboard, row, i, n))
            {
                rowboard[row][i] = 'Q';
                nQueen(rowboard, row + 1, n);
                rowboard[row][i] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n)
    {
        vector<string> rowboard(n, string(n, '.'));
        nQueen(rowboard, 0, n);
        return chessBoard;
    }
};
// @lc code=end

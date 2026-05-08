class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        for (int i = 0; i < rows; i++) {
            applyGravity(boxGrid[i], cols);
        }

        char[][] rotated = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotated[i][j] = boxGrid[rows - 1 - j][i];
            }
        }

        return rotated;
    }

    private void applyGravity(char[] row, int length) {
        int emptySlot = length - 1;

        for (int i = length - 1; i >= 0; i--) {
            if (row[i] == '*') {
                emptySlot = i - 1;
            } else if (row[i] == '#') {
                row[i] = '.';
                row[emptySlot] = '#';
                emptySlot--;
            }
        }
    }
}

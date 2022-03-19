public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;

    public Theater(int rowCount, int colCount) {
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        seats = new Seat[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        int row = getRowIndex(rowChar) + 1;

        // 범위를 벗어나는 수 입력시
        if (row > rowCount || col > colCount || col + numSeat - 1 > colCount) {
            return false;
        }

        for (int i = col; i < col + numSeat; i++){
            if (seats[row - 1][i - 1].isOccupied()) {
                return false;
            }
        }

        for (int j = col; j < col + numSeat; j ++){
            seats[row - 1][j - 1].reserve(name);
        }

        return true;
    }

    public int cancel(String name) {
        // 여기에 코드를 작성하세요
        int count = 0;
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < colCount; j++){
                if (seats[i][j].isOccupied() && seats[i][j].match(name)) {
                    seats[i][j].cancel();
                    count ++;
                }
            }
        }
        return count;
    }

    public int cancel(char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        int row = getRowIndex(rowChar) + 1;
        int limit = col + numSeat - 1;

        if (row > rowCount || col > colCount) {
            return 0;
        }
        if (limit > colCount) {
            limit = colCount;
        }

        int count = 0;

        for (int i = col; i < limit; i++){
            if (seats[row - 1][i - 1].isOccupied()) {
                seats[row - 1][i - 1].cancel();
                count ++;
            }
        }
        return count;
    }


    public int getNumberOfReservedSeat() {
        // 여기에 코드를 작성하세요
        int count = 0;
        for (int i = 0; i< rowCount; i++){
            for (int j = 0; j< colCount; j++){
                if (seats[i][j].isOccupied()){
                    count ++;
                }
            }
        }
        return count;
    }





    public void printSeatMatrix () {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}

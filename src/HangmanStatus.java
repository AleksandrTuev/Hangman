public class HangmanStatus {
    public static String[] getHangmanStatus(int count){
        String[] arr;
        switch (count){
            case 0:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        "    | ",
                        "    | ",
                        "    | ",
                        "____|_"};
                return arr;
            case 1:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        "    | ",
                        "    | ",
                        "____|_"};
                return arr;
            case 2:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        " |  | ",
                        "    | ",
                        "____|_"};
                return arr;
            case 3:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        "/|  | ",
                        "    | ",
                        "____|_"};
                return arr;
            case 4:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        "/|\\ | ",
                        "    | ",
                        "____|_"};
                return arr;
            case 5:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        "/|\\ | ",
                        "/   | ",
                        "____|_"};
                return arr;
            case 6:
                arr = new String[]{
                        " ___  ",
                        " |  | ",
                        " O  | ",
                        "/|\\ | ",
                        "/ \\ | ",
                        "____|_"};
                return arr;
            default:
                throw new IllegalArgumentException("Переданное число не соответствует диапазону чисел");
        }
    }
}

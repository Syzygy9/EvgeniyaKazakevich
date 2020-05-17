package hw_API.enums;

public class TestData {

    public enum TestDataSet {

        RUS_WORD("морковка", "морковка"),
        ENG_WORD("bumblebee", "bumblebee"),
        UKR_WORD("блакитний", "блакитний"),
        RUS_WRONG_WORD("вдохнавение", "вдохновение"),
        ENG_WRONG_WORD("skycsraper", "skyscraper"),
        UKR_WRONG_WORD("запропонуватi", "запропонувати"),
        RUS_PHRASE("Я купил лапочку", "Я купил лампочку"),
        ENG_PHRASE("Night slowly passed", "Night slowly passed"),
        UKR_PHRASE("Як справи?", "Як справи?"),
        RUS_WRONG_PHRASE("Аннушка разлила мсло", "масло"),
        ENG_WRONG_PHRASE("The sun is gong down", "going"),
        UKR_WRONG_PHRASE ("Дуже декую", "дякую");

        private String correct;
        private String wrong;

        TestDataSet(String wrong, String correct) {
            this.correct = correct;
            this.wrong = wrong;
        }

        public String getCorrect() {
            return correct;
        }
        public String getWrong() {
            return wrong;
        }
    }

    public enum TestDataWithOptions {

        DATA_IGNORE_DIGITS("4you"),
        DATA_IGNORE_URL("admin@kino-teater.ru"),
        DATA_REPEAT_WORD("easy easy"),
        DATA_IGNORE_CAPITAL("пушкин");

        private String value;

        TestDataWithOptions(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum InvalidDataInputs {

        INVALID_TEXT("?//[]+"),
        INVALID_LANGUAGE("和平"),
        INVALID_OPTIONS("1000");

        private String value;

        InvalidDataInputs(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

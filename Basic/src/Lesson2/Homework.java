package Lesson2;

public class Homework {
    public static void main(String[] args) {

        // Дана строка sql-запроса:
        //select * from students where "
        //Сформируйте часть WHERE этого запроса, используя StringBuilder. Пример данных для фильтрации приведены ниже
        // в виде json-строки. Если значение null, то параметр не должен попадать в запрос.
        System.out.println(answer("select * from students where ",
                "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} "));
    }

    public static String answer(String QUERY, String PARAMS) {
        StringBuilder whereClause = new StringBuilder();

        try {
            // Убираем фигурные скобки и разделяем параметры
            String[] paramsArray = PARAMS.replace("{", "")
                    .replace("}", "")
                    .split(", ");

            // Проходим по параметрам и формируем часть WHERE
            for (String param : paramsArray) {
                String[] keyValue = param.split(":");
                String key = keyValue[0].replace("\"", "").trim();
                String value = keyValue[1].replace("\"", "").trim();

                // Пропускаем параметры со значением "null"
                if (!value.equals("null")) {
                    if (whereClause.length() > 0) {
                        whereClause.append(" and ");
                    }
                    whereClause.append(key).append("='").append(value).append("'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return QUERY + whereClause.toString();
    }
}
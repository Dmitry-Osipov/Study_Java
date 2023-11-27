package Lesson7;

import Lesson7.builder.Order;
import Lesson7.builder.OrderBuilder;
import Lesson7.observer.*;
import Lesson7.singleton.Settings;

public class Program {
    public static void main(String[] args) {
        //Singleton
        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        System.out.println(settings2.equals(settings1));

//        Settings settings4 = new Settings();
//        System.out.println(settings4.equals(settings1));

        //Builder
        StringBuilder stringBuilder = new StringBuilder("AAA");
        String str = stringBuilder
                .append("BBB")
                .append("CCC")
                .replace(1, 3, "DDD")
                .delete(1, 5)
                .toString();
        System.out.println(str);

        Order order = new OrderBuilder()
                .setProductName("AAA")
                .setPrice(200)
                .setCount(2)
                .setSign(true)
                .build();

        //Factory
        //Описано в соответствующем классе пакета factory.

        //Adapter
        //Описано в соответствующем классе пакета adapter.

        //Observer
        /**
         *  TODO: Доработать приложение, которое разрабатывалось на семинаре,
         *  поработать с шаблоном проектирования Observer,
         *  добавить новый тип соискателя.
         *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
         *  Только после этого вы можете усложнить ваше приложение (при желании), например,
         *  добавить тип вакансии (enum),
         *  учитывать тип вакансии при отправке предложения соискателю.
         */
        Student student1 = new Student("Студент");
        Master master1 = new Master("Мастер");
        Cleaning cleaning1 = new Cleaning("Уборщица");

        Publisher publisher = new JobAgency();
        publisher.registerObserver(student1);
        publisher.registerObserver(master1);
        publisher.registerObserver(cleaning1);

        Company google = new Company("Google", publisher, 120000);
        Company yandex = new Company("Yandex", publisher, 95000);
        Company geekBrains = new Company("GeekBrains", publisher, 98000);

        Vacancy expert = new Vacancy("Мастер", 150000);
        Vacancy intern = new Vacancy("Студент", 3000);
        Vacancy cleaning = new Vacancy("Уборщица", 30000);

        google.needEmployee(expert);
        yandex.needEmployee(intern);
        geekBrains.needEmployee(cleaning);
    }
}

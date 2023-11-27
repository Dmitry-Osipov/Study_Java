package Lesson7.observer;


public class Company {
    private String name;
    private Publisher jobAgency;
    private int maxSalary;


    public Company(String name, Publisher jobAgency, int maxSalary) {
        this.name = name;
        this.jobAgency = jobAgency;
        this.maxSalary = maxSalary;
    }

    public void needEmployee(Vacancy vacancy){
        if (vacancy == null){
            throw new RuntimeException("Укажите название вакансии.");
        }

        jobAgency.sendOffer(name, vacancy.getSalary(), vacancy);
    }

    public String getName() {
        return name;
    }

    public Publisher getJobAgency() {
        return jobAgency;
    }

    public int getMaxSalary() {
        return maxSalary;
    }
}

package testdata;

import utils.Class1;

import java.time.LocalDate;

public class Class2 {

    private final Class1 gen = new Class1();

    // Faker-данные
    public final String firstName  = gen.firstName();
    public final String lastName   = gen.lastName();
    public final String userEmail  = gen.email();
    public final String userNumber = gen.phone();

    // адрес
    public final String currentAddress       = gen.fullAddress();
    public final String currentAddressRandom = gen.getRandomAddress();

    // пол / дата
    public final String genderRandom = gen.getRandomGender();

    public final LocalDate randomDate = gen.getRandomDate();
    public final String dayRandom   = gen.getRandomDay(randomDate);
    public final String monthRandom = gen.getRandomMonth(randomDate);
    public final String yearRandom  = gen.getRandomYear(randomDate);

    // предмет / хобби
    public final String subjectRandom = gen.getRandomSubject();
    public final String hobbyRandom   = gen.getRandomHobby();

    // штат → город
    public final String stateRandom = gen.getRandomState();
    public final String cityRandom  = gen.getRandomCity(stateRandom);

    // «неверное» значение для негативных тестов
    public final String wrongValueRandom = gen.getRandomString(10);
}

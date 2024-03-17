package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private SelenideElement setMounthDropdown = $(".react-datepicker__month-select");
    private SelenideElement setYearDropdown = $(".react-datepicker__year-select");
    private ElementsCollection setDayInsideMonth = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");


    public void setCalendarDate(String day, String month, String year) {


        setYearDropdown.selectOption(year);
        setMounthDropdown.selectOption(month);
        setDayInsideMonth.find(Condition.text(day)).click();

    }

}

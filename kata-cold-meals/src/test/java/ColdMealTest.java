import entities.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.CsvParser;
import services.ColdMealService;

import java.util.List;

public class ColdMealTest {

    private final ColdMealService coldMealService = new ColdMealService();

    @Test
    public void should_return_zero_cold_meal_given_no_participation_yet() {

        String filePath = filePathWithNoParticipationYet;

        int coldMealNumber = coldMealService.countColdMeal(filePath);

        Assertions.assertEquals(0, coldMealNumber);
    }

    @Test
    public void should_return_zero_cold_meal_given_no_checkin_done_yet() {

        String filePath = filePathWithAllNoCheckin;

        int coldMealNumber = coldMealService.countColdMeal(filePath);

        Assertions.assertEquals(0, coldMealNumber);
    }

    @Test
    public void should_return_zero_cold_meal_given_all_checkin_before_21_hour() {

        String filePath = filePathWithAllCheckinBefore21;

        int coldMealNumber = coldMealService.countColdMeal(filePath);

        Assertions.assertEquals(0, coldMealNumber);
    }


}

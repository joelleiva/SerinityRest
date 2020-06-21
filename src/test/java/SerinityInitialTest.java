import javafx.beans.binding.BooleanExpression;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

//utilizar el serenty runner
@RunWith(SerenityRunner.class)
public class SerinityInitialTest {
    //pegar el endpoint
    private static final String restApiUrl = "https://reqres.in/api/users?page=2";

    @Test
    public void getUsers() {
        Actor julian = Actor.named("Joel in trainer")
                .whoCan(CallAnApi.at(restApiUrl));
        //llamar al recurso
        julian.attemptsTo(
                //se llama a una clase
                GetUsers.fromPage(2)
        );

        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }




}

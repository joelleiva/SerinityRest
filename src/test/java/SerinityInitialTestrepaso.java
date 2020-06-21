import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SerinityInitialTestrepaso {

    private static final String restApiUrl = "https://reqres.in/api/users?page=2";

    @Test
    public void getUsers(){
       Actor Joel = Actor.named("Joel in trainer")
               .whoCan(CallAnApi.at(restApiUrl));
       Joel.attemptsTo(
               GetUsers.fromPage(2)
       );
       assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }

}

package co.com.falabella.stepDefinitions;


import co.com.falabella.Tasks.AgregarProductoTask;
import co.com.falabella.questions.ValidarProducto;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AgregarProductoStepDefinition {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }
    @Dado("que el usuario encuentre la url de libreria nacional")
    public void que_el_usuario_encuentre_la_url_de_libreria_nacional() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://www.falabella.com.co/")
        );
    }

    @Cuando("el usuario seleccione el producto al carrito")
    public void el_usuario_seleccione_el_producto_al_carrito() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoTask.on()


        );
    }

    @Entonces("se validara producto agregado exitosamente")
    public void se_validara_producto_agregado_exitosamente() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarProducto.on(), Matchers.equalTo(true)
                )
        );
    }

}

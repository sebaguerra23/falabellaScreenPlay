package co.com.falabella.Tasks;


import co.com.falabella.interactions.ClickRamdom;
import co.com.falabella.ui.AgregarProductoUI;
import co.com.falabella.utils.Excel;
import co.com.falabella.utils.VentanaHija;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;


import java.io.IOException;

import static co.com.falabella.ui.AgregarProductoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductoTask implements Task {

    Excel excel = new Excel();
    AgregarProductoUI agregarProductoUI = new AgregarProductoUI();



    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            actor.attemptsTo(


                    WaitUntil.the( BTN_BUSCAR, isClickable() ).forNoMoreThan( 30 ).seconds(),
                    Enter.theValue( excel.leerDatosExcel( "Data.xlsx","Productos",1,0) ).into( BTN_BUSCAR ).thenHit( Keys.ENTER ),
                    WaitUntil.the( LBL_PRODUCTO, isClickable() ).forNoMoreThan( 30 ).seconds(),
                    ClickRamdom.on(),
                    WaitUntil.the( LBL_PRECIO, isClickable() ).forNoMoreThan( 30 ).seconds(),
                    Scroll.to( LBL_PRECIO ),
                    WaitUntil.the( TXT_CANTIDAD_STOP, isClickable() ).forNoMoreThan( 30 ).seconds(),
                    Clear.field( TXT_CANTIDAD_STOP ),
                    Enter.theValue( excel.leerDatosExcel( "Data.xlsx", "Productos",1,1)).into( TXT_CANTIDAD_STOP ).thenHit( Keys.ENTER ),
                    Click.on( BTN_AGREGAR_PRODUCTO ),
                    VentanaHija.change( BrowseTheWeb.as(actor).getDriver().getWindowHandle()),
                    WaitUntil.the( VALIDAR_CANTIDAD_PRODUCTO, isVisible() ).forNoMoreThan( 30 ).seconds(),
                    Ensure.that(VALIDAR_CANTIDAD_PRODUCTO).isEnabled()
            );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }


    }
    public static Performable on(){

        return Tasks.instrumented(AgregarProductoTask.class);
    }
}
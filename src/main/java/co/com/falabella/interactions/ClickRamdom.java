package co.com.falabella.interactions;

import co.com.falabella.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.AgregarProductoUI.LBL_PRODUCTO;


public class ClickRamdom implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listaProductos = LBL_PRODUCTO.resolveAllFor( actor );
        Random random = new Random();
        int indexRamdom = random.nextInt(listaProductos.size() );

        String nombreProducto = listaProductos.get(indexRamdom).getText();
        EscrituraExcel.escrituraExcel( "Validacion.xlsx",nombreProducto,1,0 );
        listaProductos.get( indexRamdom ).click();
    }

    public static ClickRamdom on(){
        return Tasks.instrumented( ClickRamdom.class);
    }


}

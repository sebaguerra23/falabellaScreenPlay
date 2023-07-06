package co.com.falabella.questions;

import co.com.falabella.utils.Excel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;

import static co.com.falabella.ui.AgregarProductoUI.VALIDAR_TITULO_PRODUCTO;


public class ValidarProducto implements Question {

    Excel excel = new Excel();
    @Override
    public Object answeredBy(Actor actor) {

        WebElementFacade mensaje = VALIDAR_TITULO_PRODUCTO.resolveFor(actor);
        String nombreMensajeBienvenida = mensaje.getText();

        try {
            return (excel.leerDatosExcel( "Validacion.xlsx", "Productos",1,0 )).equals(nombreMensajeBienvenida);
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
    public static Question<Boolean> on(){
        return  new ValidarProducto();
    }

    }


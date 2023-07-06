package co.com.falabella.ui;

import co.com.falabella.utils.Excel;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

public class AgregarProductoUI {

    static Excel excel = new Excel();
    public static final Target BTN_BUSCAR= Target.the( "Btn buscar" )
            .located( By.xpath("//div/input[@class='SearchBar-module_searchBar__Input__1kPKS']") );
    public static final Target LBL_PRODUCTO= Target.the( "lbl producto" )
            .located( By.xpath("//div[@class='jsx-1576191951 pod-title-wrapper']/span[1]/b") );
    public static final Target TXT_CANTIDAD_STOP= Target.the( "txt cantidad producto" )
            .located( By.xpath("//div/input[@id='quantity-selector-increment-input']") );
    public static final Target BTN_AGREGAR_PRODUCTO= Target.the( "Btn agregar producto" )
            .located( By.xpath("//div/button[@id='add-to-cart-button']") );
    public static final Target VALIDAR_TITULO_PRODUCTO= Target.the( "Titulo producto" )
            .located( By.xpath("//div[@class='jsx-4205635298 item-info']/span[2]") );
    public static final Target LBL_PRECIO= Target.the( "Titulo producto" )
            .located( By.xpath("//div/ol/li/div/span") );

    public static Target VALIDAR_CANTIDAD_PRODUCTO = null;

    static {
        try {
            VALIDAR_CANTIDAD_PRODUCTO= Target.the( "Titulo producto" )
                    .located( By.xpath("//div[@class='jsx-4205635298 stepper']/div/div/input[@value='"+excel.leerDatosExcel( "Data.xlsx", "Productos",1,1)+"']") );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }

    }

}

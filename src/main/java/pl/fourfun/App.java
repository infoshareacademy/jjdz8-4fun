package pl.fourfun;


import pl.fourfun.readwriteproducts.CheckProductFile;

import java.io.IOException;
import pl.fourfun.menutypes.Menu;

class App
{

    public static void main( String[] args ) throws IOException, InterruptedException {

        CheckProductFile.checkingExistProductFile();
        CheckProductFile.checkingExistUserFile();
        Menu.showMainMenu();

    }
}

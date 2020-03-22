package pl.fourfun;


import pl.fourfun.readwriteproducts.AddProductToUserList;
import pl.fourfun.readwriteproducts.CheckProductFile;

import java.io.IOException;

class App
{

    public static void main( String[] args ) throws IOException, InterruptedException {

        CheckProductFile.checkingExistProductFile();
        CheckProductFile.checkingExistUserFile();
        pl.fourfun.Menu.showMainMenu();
    }
}

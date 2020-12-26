package main;

import house.BangladeshiFarmersHouse;
import house.IHouse;
import house.NullHouse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tree.BangladeshiFarmersTree;
import tree.ITree;
import tree.NullTree;
import waterSource.IWaterSource;
import waterSource.NullWaterSource;
import waterSource.Pond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private Pane main_pane;

    @FXML
    private AnchorPane drawing_space;

    @FXML
    private Button newVillage_Button;

    @FXML
    private Button openVillage_Button;

    @FXML
    private Button saveVillage_Button;

    @FXML
    private RadioButton water_RadioButton;

    @FXML
    private RadioButton tree_RadioButton;

    @FXML
    private RadioButton house_RadioButton;

    @FXML
    private Label nation_name;

    @FXML
    private Label village_name;

    public static Label vn_label,cn_label;

    @FXML
    private Canvas drawing_space_canvas;


    @FXML
    void newVillage_Button_Clicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) newVillage_Button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("InputTakeWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Age of Villagers");
        stage.setScene(new Scene(root, 600, 310));
        stage.setResizable(false);
        stage.show();
    }
    /*private BangladeshiFarmer bangladeshiFarmer;
    private BangladeshiFarmersHouse bangladeshiFarmersHouse;
    private BangladeshiFarmersTree bangladeshiFarmersTree;
    private Pond pond;*/
    private Canvas canvas;


    public static String nation;
    private IHouse house;
    private ITree tree;
    private IWaterSource waterSource;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cn_label = nation_name;
        vn_label = village_name;
        toggleGroup = new ToggleGroup();

        house = new BangladeshiFarmersHouse();
        tree = new BangladeshiFarmersTree();
        waterSource = new Pond();

        MainCanvas mainCanvas = MainCanvas.getInstance();
        canvas = mainCanvas.getCanvas();
        drawing_space.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void RadioSelect(ActionEvent actionEvent)
    {
        if (house_RadioButton.isSelected())
        {
            house.Draw();
            house.draw_house();
            tree.Dont_Draw();
            waterSource.Dont_Draw();
        }
        else if (tree_RadioButton.isSelected())
        {
            tree.Draw();
            tree.draw_Tree();
            house.Dont_Draw();
            waterSource.Dont_Draw();
        }
        else if(water_RadioButton.isSelected())
        {
            waterSource.Draw();
            waterSource.draw_water_resource();
            house.Dont_Draw();
            tree.Dont_Draw();
        }

    }

    public void NewVillageCreation()
    {
        System.out.println(nation);
        if (nation == "Bangladeshi Farmers")
        {
            house = new BangladeshiFarmersHouse();
            tree = new BangladeshiFarmersTree();
            waterSource = new Pond();
        }
        else if (nation == "Egyptian Kings")
        {

        }
        else if(nation == "Arab Bedouin")
        {

        }
        else
        {
            house = new NullHouse();
            tree = new NullTree();
            waterSource = new NullWaterSource();
        }
    }
    /*@FXML
    public void House_Button_Clicked (ActionEvent event){
        if (house_RadioButton.isSelected()) {
            bangladeshiFarmersHouse.Draw();
            bangladeshiFarmersHouse.draw_house();
            bangladeshiFarmersHouse.Dont_Draw();
        }
        else {
            bangladeshiFarmersHouse.Dont_Draw();
        }
    }

    @FXML
    void Tree_Button_Clicked (ActionEvent event){
        if (tree_RadioButton.isSelected()) {
            bangladeshiFarmersTree.Draw();
            bangladeshiFarmersTree.draw_Tree();
        }
        else {
            bangladeshiFarmersTree.Dont_Draw();
        }
    }

    @FXML
    void WaterSource_Button_Clicked (ActionEvent event){
        if (water_RadioButton.isSelected()) {
            pond.Draw();
            pond.draw_water_resource();
        }
        else {
            pond.Dont_Draw();
        }
    }*/

}



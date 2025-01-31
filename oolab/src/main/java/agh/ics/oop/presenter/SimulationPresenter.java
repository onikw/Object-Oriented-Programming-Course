package agh.ics.oop.presenter;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.simulation.Simulation;
import agh.ics.oop.simulation.SimulationEngine;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {


    private final static String ERROR_MESSAGE = "Wrong moves, try again";


    private static final int MAX_MAP_SIZE=400;

    @FXML
    public Button startButton;
    @FXML
    public TextField moveList;
    @FXML
    public GridPane mapGrid;
    @FXML
    private Label infoLabel;





    @Override
    public void mapChanged(WorldMap worldMap, String message)
    {

        Platform.runLater(() -> {

            clearGrid();
            drawMap(worldMap);
            infoLabel.setText(message);


        });
    }
    private void drawMap(WorldMap worldMap)
    {
        Boundary currentBounds = worldMap.getCurrentBounds();
        int xMax= currentBounds.upperRight().getX();
        int yMax= currentBounds.upperRight().getY();
        int xMin= currentBounds.lowerLeft().getX();
        int yMin= currentBounds.lowerLeft().getY();
        int MAP_WIDTH = xMax-xMin+1;
        int MAP_HEIGHT = yMax-yMin+1;
        int RECT_CELL_SIZE;
        if (MAP_WIDTH>MAP_HEIGHT)
        {
            RECT_CELL_SIZE = MAX_MAP_SIZE /MAP_WIDTH;
        }
        else
        {
            RECT_CELL_SIZE = MAX_MAP_SIZE /MAP_HEIGHT;
        }

        Label label = new Label("y/x");
        GridPane.setHalignment(label, HPos.CENTER);
        mapGrid.add(label,0,0);
        mapGrid.getRowConstraints().add(new RowConstraints(RECT_CELL_SIZE));
        mapGrid.getColumnConstraints().add(new ColumnConstraints(RECT_CELL_SIZE));


        //drawing y indexes "
        for(int i=0; i<MAP_HEIGHT; i++){
            label = new Label(Integer.toString(yMax-i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,0,i+1);
            mapGrid.getRowConstraints().add(new RowConstraints(RECT_CELL_SIZE));

        }
        //drawing x indexes "
        for(int i=0; i<MAP_WIDTH; i++){
            label = new Label(Integer.toString(xMin+i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,i+1,0);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(RECT_CELL_SIZE));

        }

        // drawing map object
        for(int i=0; i<MAP_WIDTH; i++)
        {
                for(int j=0; j<MAP_HEIGHT; j++)
                {

                    Vector2d pos = new Vector2d(i+xMin, j+yMin);
                    if(worldMap.isOccupied(pos)) {
                        label = new Label(worldMap.objectAt(pos).toString());
                        label.setStyle("-fx-text-fill: #2b8066");
                    }
                     else
                         label = new Label(" ");

                    GridPane.setHalignment(label, HPos.CENTER);
                    mapGrid.add(label,i+1, MAP_HEIGHT-j);

                }


        }


    }
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().getFirst()); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @FXML
    private void onSimulationStartClicked() {
        String move = moveList.getText();
        String[] args = move.split(" ");



        List<Simulation> simulations = new ArrayList<>();
        List<MoveDirection> directions;
        try{
        directions = OptionsParser.parse(args);
        }
        catch (IllegalArgumentException e)
        {
            infoLabel.setText(ERROR_MESSAGE);
            return;
        }
//
//        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
//        AbstractWorldMap newRecMap = new RectangularMap(4,4);
//        newRecMap.addObserver(this);
//        Simulation simulation = new Simulation(positions, directions,newRecMap);
//        simulations.add(simulation);
        AbstractWorldMap grassMap = new GrassField(10);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
        grassMap.addObserver(this);
        Simulation simulation = new Simulation(positions, directions, grassMap);
        simulations.add(simulation);
        SimulationEngine engine = new SimulationEngine(simulations);

        new Thread(engine::runSync).start();
    }
}

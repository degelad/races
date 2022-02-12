package org.degelad.races;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author degelad
 */
public class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }    
}

package cz.cvut.fel.omo.observers;

import cz.cvut.fel.omo.model.AbstractEntity;

/**
 * This class is an abstract class for observer.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public abstract class Observer {

    protected AbstractEntity entity;

    /**
     * Constructor for Observer.
     * @param entity AbstractEntity
     */
    public Observer(AbstractEntity entity) {

        this.entity = entity;
        this.entity.attach(this);
    }

    /**
     * This method updates instance.
     */
    public abstract void update();
}

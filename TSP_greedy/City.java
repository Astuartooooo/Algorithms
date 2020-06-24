/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspimproved;

/**
 *
 * @author 81265
 */

/**
 *
 * @author 81265p
 */
public class City {

    private int id;
    private int xCoordinate;
    private int yCoordinate;

    public City(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    
    public double distance(City destination) {
        return Math.sqrt(Math.pow(destination.getxCoordinate() - this.getxCoordinate(), 2) + Math.pow(destination.getyCoordinate() - this.getyCoordinate(), 2));
    }
    
}
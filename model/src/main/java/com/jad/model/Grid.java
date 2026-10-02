package com.jad.model;

import java.awt.*;

public final class Grid {
    private final Dimension dimension;
    private final Tile[][] tiles;

    public Grid(Dimension dimension) {
        this.dimension = dimension;
        this.tiles = new Tile[dimension.height][dimension.width];
        for (int row = 0; row < dimension.height; row++){
            for (int column = 0; column < dimension.width; column++){
                this.tiles[row][column] = Tile.EMPTY;
            }
        }

    }
    public final Tile getTileAt(final Point position){
        final Point wrappedPosition = this.wrapPosition(position);
        return this.tiles[wrappedPosition.y][wrappedPosition.x];
    }

    private Point wrapPosition(final Point position){
        return new Point(position.x % this.dimension.width, position.y % this.dimension.height);
    }

    public boolean isObstacle(final Point position){
        return this.getTileAt(position).isObstacle();
    }

    public void setTileAt(final Tile tile, final Point position){
        final Point wrappedPosition = this.wrapPosition(position);
        this.tiles[wrappedPosition.y][wrappedPosition.x] = tile;
    }
}

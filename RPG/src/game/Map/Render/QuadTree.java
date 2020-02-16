package game.Map.Render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import game.Map.Tile;

public class QuadTree {
	
	private Rectangle boundary;
	private int capacity;
	private List<Tile> objects = new ArrayList<>();
	
	private boolean divided = false;
	
	//QuadTree
	private QuadTree northeast;
	private QuadTree northwest;
	private QuadTree southeast;
	private QuadTree southwest;
	
	public QuadTree(Rectangle boundary, int capacity) {

		this.boundary = boundary;
		this.capacity = capacity;
		this.divided = false;

	}
	
	public void subdivide() {
	    int x = this.boundary.x;
	    int y = this.boundary.y;
	    int w = this.boundary.width;
	    int h = this.boundary.height;

	    Rectangle nw = new Rectangle(x,  y , w / 2, h / 2);
	    this.northwest = new QuadTree(nw, this.capacity);
	    
	    Rectangle ne = new Rectangle(w / 2 + x, y , w / 2, h / 2);
	    this.northeast = new QuadTree(ne, this.capacity);
	    
	    Rectangle sw = new Rectangle(x, h / 2 + y, w / 2, h / 2);
	    this.southwest = new QuadTree(sw, this.capacity);
	    
	    Rectangle se = new Rectangle(w / 2 + x, h / 2 + y, w / 2, h / 2);
	    this.southeast = new QuadTree(se, this.capacity);
	    

	    this.divided = true;
	}
	
	public boolean insert(Tile object) {
    
		if (!this.boundary.intersects(object.getBounds())) { 
		      return false;
		}
		    

		if (this.objects.size() < this.capacity) {
			this.objects.add(object);
		    return true;
		} 
		else {
			if (!this.divided) 
				this.subdivide();
		    	
			if (this.northeast.insert(object) ||
				this.northwest.insert(object) || 
				this.southeast.insert(object) ||
				this.southwest.insert(object)) 
				return true;
     
		}
		return false;
	}
	
	public List<Tile> query(Rectangle range, List<Tile> objs) {
	    if (objs == null) 
	    	objs = new ArrayList<>();
	    	
	    if (this.boundary.intersects(range)){
	        for (Tile obj : this.objects) {
	          if (range.intersects(obj.getBounds())) {
	        	  objs.add(obj);
	         }
	        }
	        if (this.divided) {
	          this.northwest.query(range, objs);
	          this.northeast.query(range, objs);
	          this.southwest.query(range, objs);
	          this.southeast.query(range, objs);
	        }
	    }
	    return objs;
	}
	
	

}

public abstract class CubeletEntity extends Entity {
	/*Class defining entities that are made up of cubelets*/
	/*
	Inherits:
	
	public int totalHeight;
	public int totalWidth;
	public int x, y;
	
	protected abstract void render();
	protected abstract void update(); 
	*/	
	public int cubeAmntWidth;  //Amount of cube in the player width  wise
	public int cubeAmntHeight; //Amount of cube in the player height wise
	public int cubeWidth;      //Width  of individual cube
	public int cubeHeight;     //Height of individual cube
	public int speed = 5;
	
	//Variables that let the entity move
	public boolean isMoveWest = false;
	public boolean isMoveEast = false;
	public boolean isMoveNorth = false;
	public boolean isMoveSouth = false;
	//Variables that stop the entity from moving if there are some restrictions
	public boolean canMoveWest = true;
	public boolean canMoveEast = true;
	public boolean canMoveNorth = true;
	public boolean canMoveSouth = true;
	
	protected void move(){ //Call move() in update() in order to move
		if(isMoveWest && canMoveWest){
			x -= speed;
			isMoveWest = false;
		}
		if(isMoveEast && canMoveEast){
			x += speed;
			isMoveEast = false;
		}
		if(isMoveNorth && canMoveNorth){
			y -= speed;
			isMoveNorth = false;
		}
		if(isMoveSouth && canMoveSouth){
			y += speed;
			isMoveSouth = false;
		}
	}
	//Setter functions for movement variables
	protected void moveWest(){
		isMoveWest = true;
	}
	protected void moveEast(){
		isMoveEast = true;
	}
	protected void moveNorth(){
		isMoveNorth = true;
	}
	public void moveSouth(){
		isMoveSouth = true;
	}
	
	
	//superSetter functions for checkCollisions
	protected void checkForCollision(){ //Call in update() before move()
		canMoveWest = checkWestCollision();
		canMoveEast = checkEastCollision();
		canMoveNorth = checkNorthCollision();
		canMoveSouth = checkSouthCollision();
	}
	//Setter functions for checkCollisions. all 4 functions are similar, so only commenting for one
	protected boolean checkWestCollision(){
		if(x < 0 + speed){ //Check if about to be offscreen
			return false;
		}
		return true; //True if isn't colliding with anything
	}
	protected boolean checkEastCollision(){
		if(x > Global.SCREEN_WIDTH - speed - totalWidth){
			return false;
		}
		return true;
	}
	protected boolean checkNorthCollision(){
		if(y < 0 + speed){
			return false;
		}
		return true;
	}
	protected boolean checkSouthCollision(){
		if(y > Global.SCREEN_HEIGHT - speed - totalHeight){
			return false;
		}
		return true;
	}
	

	

}


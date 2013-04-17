package pe.com.sf.re.fi.memory;


public class ImageResize {
	
	private int pointx,pointy,pointArrastreX,pointArrastreY;
	private int original_width, original_height, bound_width, bound_height, new_width, new_height   ;
	
	public ImageResize() {
	}
	
	
	

	public ImageResize(int original_width, int original_height, int bound_width, int bound_height, int new_width, int new_height) {
		super();
		this.original_width = original_width;
		this.original_height = original_height;
		this.bound_width = bound_width;
		this.bound_height = bound_height;
		this.new_width = new_width;
		this.new_height = new_height;
	}




	public ImageResize(int pointx, int pointy, int pointArrastreX, int pointArrastreY) {
		super();
		this.pointx = pointx;
		this.pointy = pointy;
		this.pointArrastreX = pointArrastreX;
		this.pointArrastreY = pointArrastreY;
	}




	public ImageResize(int pointx, int pointy, int pointArrastreX, int pointArrastreY, int original_width, int original_height, int bound_width,
			int bound_height, int new_width, int new_height) {
		super();
		this.pointx = pointx;
		this.pointy = pointy;
		this.pointArrastreX = pointArrastreX;
		this.pointArrastreY = pointArrastreY;
		this.original_width = original_width;
		this.original_height = original_height;
		this.bound_width = bound_width;
		this.bound_height = bound_height;
		this.new_width = new_width;
		this.new_height = new_height;
	}




	public int getPointx() {
		return pointx;
	}

	public void setPointx(int pointx) {
		this.pointx = pointx;
	}

	public int getPointy() {
		return pointy;
	}

	public void setPointy(int pointy) {
		this.pointy = pointy;
	}

	public int getPointArrastreX() {
		return pointArrastreX;
	}

	public void setPointArrastreX(int pointArrastreX) {
		this.pointArrastreX = pointArrastreX;
	}

	public int getPointArrastreY() {
		return pointArrastreY;
	}

	public void setPointArrastreY(int pointArrastreY) {
		this.pointArrastreY = pointArrastreY;
	}

	public int getOriginal_width() {
		return original_width;
	}

	public void setOriginal_width(int original_width) {
		this.original_width = original_width;
	}

	public int getOriginal_height() {
		return original_height;
	}

	public void setOriginal_height(int original_height) {
		this.original_height = original_height;
	}

	public int getBound_width() {
		return bound_width;
	}

	public void setBound_width(int bound_width) {
		this.bound_width = bound_width;
	}

	public int getBound_height() {
		return bound_height;
	}

	public void setBound_height(int bound_height) {
		this.bound_height = bound_height;
	}

	public int getNew_width() {
		return new_width;
	}

	public void setNew_width(int new_width) {
		this.new_width = new_width;
	}

	public int getNew_height() {
		return new_height;
	}

	public void setNew_height(int new_height) {
		this.new_height = new_height;
	}

	
	
}

package pe.com.sf.re.fi.memory;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListaImageResize {

	private File file;
	private Image img;
	private List<ImageResize> lst  = null;
	
	public ListaImageResize(Image i){
		lst = new ArrayList<ImageResize>();
		img=i;
	}
	
	public void addList(ImageResize i){
		lst.add(i);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public List<ImageResize> getLst() {
		return lst;
	}

	public void setLst(List<ImageResize> lst) {
		this.lst = lst;
	}
	
	
	
}

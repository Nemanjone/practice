
public class Point3D<UnitType> {
	
	private final UnitType x, y, z;

	public Point3D(UnitType x, UnitType y, UnitType z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public UnitType getX() {
		return x;
	}

	public UnitType getY() {
		return y;
	}

	public UnitType getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	

}

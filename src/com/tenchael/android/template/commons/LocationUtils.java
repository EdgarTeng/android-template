package com.tenchael.android.template.commons;

public class LocationUtils {

	private LocationUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 
	 * @param lon1
	 *            第一点的经度
	 * @param lat1
	 *            第一点的纬度
	 * @param lon2
	 *            第二点的经度
	 * @param lat2
	 *            第二点的纬度
	 * @return
	 */
	public static double distance(double lon1, double lat1, double lon2,
			double lat2) {
		double theta = lon1 - lon2;// 经度�?
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	public static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}

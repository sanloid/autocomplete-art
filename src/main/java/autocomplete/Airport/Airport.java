package autocomplete.Airport;

public class Airport {
    private Integer id;
    private String name;
    private String city;
    private String country;
    private String iataCode;
    private String icaoCode;
    private Double latitude;
    private Double longitude;
    private Integer altitude;
    private Double timezone;
    private String dst;
    private String timeZone;
    private String type;
    private String source;

    public Airport(Integer id, String name, String city, String country, String iataCode, String icaoCode,
            Double latitude, Double longitude, Integer altitude, Double timezone, String dst,
            String timeZone, String type, String source) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.dst = dst;
        this.timeZone = timeZone;
        this.type = type;
        this.source = source;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Double getTimezone() {
        return timezone;
    }

    public void setTimezone(Double timezone) {
        this.timezone = timezone;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + ", city: " + city + ", country: " + country + ", iataCode: "
                + iataCode + ", icaoCode: " + icaoCode + ", latitude: " + latitude + ", longitude: " + longitude
                + ", altitude: " + altitude + ", timezone: " + timezone + ", dst: " + dst + ", timeZone: " + timeZone
                + ", type: " + type + ", source: " + source + "}";

    }

    public Object getColumn(Integer n) {
        switch (n) {
            case 1:
                return getId();
            case 2:
                return getName();
            case 3:
                return getCity();
            case 4:
                return getCountry();
            case 5:
                return getIataCode();
            case 6:
                return getIcaoCode();
            case 7:
                return getLatitude();
            case 8:
                return getLongitude();
            case 9:
                return getAltitude();
            case 10:
                return getTimezone();
            case 11:
                return getDst();
            case 12:
                return getTimeZone();
            case 13:
                return getType();
            case 14:
                return getSource();
            default:
                throw new IllegalArgumentException("Invalid column number provided: " + n);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((iataCode == null) ? 0 : iataCode.hashCode());
        result = prime * result + ((icaoCode == null) ? 0 : icaoCode.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((altitude == null) ? 0 : altitude.hashCode());
        result = prime * result + ((timezone == null) ? 0 : timezone.hashCode());
        result = prime * result + ((dst == null) ? 0 : dst.hashCode());
        result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Airport other = (Airport) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (iataCode == null) {
            if (other.iataCode != null)
                return false;
        } else if (!iataCode.equals(other.iataCode))
            return false;
        if (icaoCode == null) {
            if (other.icaoCode != null)
                return false;
        } else if (!icaoCode.equals(other.icaoCode))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (altitude == null) {
            if (other.altitude != null)
                return false;
        } else if (!altitude.equals(other.altitude))
            return false;
        if (timezone == null) {
            if (other.timezone != null)
                return false;
        } else if (!timezone.equals(other.timezone))
            return false;
        if (dst == null) {
            if (other.dst != null)
                return false;
        } else if (!dst.equals(other.dst))
            return false;
        if (timeZone == null) {
            if (other.timeZone != null)
                return false;
        } else if (!timeZone.equals(other.timeZone))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        return true;
    }
}

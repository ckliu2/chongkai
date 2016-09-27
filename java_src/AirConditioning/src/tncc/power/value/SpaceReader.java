package tncc.power.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;


/** @author Hibernate CodeGenerator */
public class SpaceReader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id;

	/** nullable persistent field */
    private String name;    

	private String seqName;

    /** nullable persistent field */
    private tncc.power.value.Space space;
    private Long spaceId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;
    
	PowerController powercontroller;

	AppProperty state;

    /** full constructor */
    public SpaceReader(String name, tncc.power.value.Space space, tncc.power.value.Reader reader) {
        this.name = name;
        this.space = space;
        this.reader = reader;
    }

    /** Labor constructor */
    public SpaceReader() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

    public tncc.power.value.Space getSpace() {
        return this.space;
    }

    public void setSpace(tncc.power.value.Space space) {
        this.space = space;
    }

    public Long getSpaceId() {
        if (this.space != null && this.space.getId() != null)
            return space.getId();
        return this.spaceId;
    }

    public void setSpaceId(Long id) {
        this.spaceId = id;
    }

    public tncc.power.value.Reader getReader() {
        return this.reader;
    }

    public void setReader(tncc.power.value.Reader reader) {
        this.reader = reader;
    }

    public Long getReaderId() {
        if (this.reader != null && this.reader.getId() != null)
            return reader.getId();
        return this.readerId;
    }

    public void setReaderId(Long id) {
        this.readerId = id;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public PowerController getPowercontroller() {
		return powercontroller;
	}

	public void setPowercontroller(PowerController powercontroller) {
		this.powercontroller = powercontroller;
	}
	
	public AppProperty getState() {
		return state;
	}

	public void setState(AppProperty state) {
		this.state = state;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("space", getSpace())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}

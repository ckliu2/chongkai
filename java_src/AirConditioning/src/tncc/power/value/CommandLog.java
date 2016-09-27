package tncc.power.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CommandLog extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;
    
    /** nullable persistent field */
    private String command;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private AppProperty commandType;
    private Long commandTypeId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** full constructor */
    public CommandLog(String command, Date createdDate, AppProperty commandType, tncc.power.value.Reader reader) {
        this.command = command;
        this.createdDate = createdDate;
        this.commandType = commandType;
        this.reader = reader;
    }

    /** Labor constructor */
    public CommandLog() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppProperty getCommandType() {
        return this.commandType;
    }

    public void setCommandType(AppProperty commandType) {
        this.commandType = commandType;
    }

    public Long getCommandTypeId() {
        if (this.commandType != null && this.commandType.getId() != null)
            return commandType.getId();
        return this.commandTypeId;
    }

    public void setCommandTypeId(Long id) {
        this.commandTypeId = id;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("command", getCommand())
            .append("createdDate", getCreatedDate())
            .append("commandType", getCommandType())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}

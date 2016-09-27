package service;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DownloadG50 extends QuartzJobBean {
    private QuartzG50 jobData;

    public void executeInternal(JobExecutionContext context)  {
    	jobData.setSchedule();
    	
    }
    
    public void setJobData(QuartzG50 jobData) {
        this.jobData = jobData;
    }
    
    public QuartzG50 getJobData() {
        return jobData;
    }
} 

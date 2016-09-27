select 
id=a.stno,rgno=a.stno,cname=b.sname,idNo=b.id_no,password=right(b.id_no,4),ename=b.ename,sex=b.sex,birthday='',ident=case when b.stu_kind in('2','3') then 21 else 20 end,departmentName=t.full_name,department=c.code_no2,status=5,zip=reg_area,address=g_regaddr,
cellphone=g_mobile,phone=g_tel,
blogUrl=case when email_bu2 is null then '' else email_bu2 end
,email=consult_mail,otherEmail1=case when email_bu1 is null then '' else email_bu1 end,majorSubject='.'
from school.dbo.consultation a --�դ͸��
left join school.dbo.tabastu b on a.stno=b.stno --�ǥͰ򥻸�ƪ�
left join school.dbo.tabamaj c on b.stno_typ = c.stno_typ and b.majr_no=c.code_no --�t�ҥN�X��
left join  tmp t on t.id='CA'+b.stno_typ+b.majr_no
where gra_flag='1' 

/*********�s�W�H��**********/
insert into COM_Member(id,rgno,cname,idNo,password,ename,sex,ident,departmentName,department,status,zip,address,cellphone,phone,blogUrl,email,otherEmail1,majorSubject)
select 
id=a.stno,rgno=a.stno,cname=b.sname,idNo=b.id_no,password=right(b.id_no,4),ename=b.ename,sex=b.sex,ident=case when b.stu_kind in('2','3') then 21 else 20 end,departmentName=t.full_name,department=c.code_no2,status=5,zip=reg_area,address=g_regaddr,
cellphone=g_mobile,phone=g_tel,
blogUrl=case when email_bu2 is null then '' else email_bu2 end
,email=consult_mail,otherEmail1=case when email_bu1 is null then '' else email_bu1 end,majorSubject='.'
from school.dbo.consultation a --�դ͸��
left join school.dbo.tabastu b on a.stno=b.stno --�ǥͰ򥻸�ƪ�
left join school.dbo.tabamaj c on b.stno_typ = c.stno_typ and b.majr_no=c.code_no --�t�ҥN�X��
left join  tmp t on t.id='CA'+b.stno_typ+b.majr_no
where gra_flag='1' 

/*********��s�ͤ�**********/
update 
m set birthday=b.birthday
from COM_Member m ,(
select  stno,birthday=
cast(1911+cast(LEFT(birthday,2) as int) as varchar)+'-'+SUBSTRING(cast(birthday as varchar),3,2)+'-'+SUBSTRING(cast(birthday as varchar),5,2)
from school.dbo.tabastu
)b where m.id=b.stno

/*********�NŪ�Ǯ� **********
DECLARE @id varchar(50),@departmentName varchar(50),@COUNT INT,@pk INT
DECLARE mycursor CURSOR FOR
select id,departmentName from com_member
OPEN mycursor 

--�N�Ĥ@����ƶ�J�ܼ�
FETCH NEXT FROM mycursor INTO @id,@departmentName
 WHILE @@FETCH_STATUS = 0  
 BEGIN  
  SET @COUNT = CHARINDEX('�դh', @departmentName)
   IF @COUNT<>0
    BEGIN      
       INSERT INTO COM_MySchools(NAME,department,degree,status,lastModifiedDate,lastModifiedUser,createdDate,createdUser)VALUES
       ('��߻O�_���N�j��',@departmentName,16,5,GETDATE(),'system',GETDATE(),'system')
       SELECT @pk=IDENT_CURRENT('COM_MySchools') 
       INSERT INTO COM_MemberMySchools(memberId,mySchoolsId,IDX)VALUES(@id,@pk,0)       
       PRINT @id+'--'+@departmentName+CAST(@PK AS VARCHAR)        
    END  
FETCH NEXT FROM mycursor  INTO @id,@departmentName
END 
CLOSE mycursor
DEALLOCATE mycursor 
*/
/*********�NŪ�ǮվǤh **********/
/*
DECLARE @id varchar(50),@departmentName varchar(50),@COUNT INT,@COUNT1 INT,@pk INT
DECLARE mycursor CURSOR FOR
select id,departmentName from com_member
OPEN mycursor 

--�N�Ĥ@����ƶ�J�ܼ�
FETCH NEXT FROM mycursor INTO @id,@departmentName
 WHILE @@FETCH_STATUS = 0  
 BEGIN  
  SET @COUNT = CHARINDEX('�դh', @departmentName)
  SET @COUNT1 = CHARINDEX('�Ӥh', @departmentName)
   IF @COUNT=0 AND @COUNT1=0
    BEGIN    
      PRINT @id+'--'+@departmentName  
       INSERT INTO COM_MySchools(NAME,department,degree,status,lastModifiedDate,lastModifiedUser,createdDate,createdUser)VALUES
       ('��߻O�_���N�j��',@departmentName,14,5,GETDATE(),'system',GETDATE(),'system')
       SELECT @pk=IDENT_CURRENT('COM_MySchools') 
       INSERT INTO COM_MemberMySchools(memberId,mySchoolsId,IDX)VALUES(@id,@pk,0)       
       PRINT @id+'--'+@departmentName+CAST(@PK AS VARCHAR)      
    END  
FETCH NEXT FROM mycursor  INTO @id,@departmentName
END 
CLOSE mycursor
DEALLOCATE mycursor 
*/
/*********�NŪ��L�Ǯ� **********/
/*
DECLARE @gra_school varchar(100),@gra_majo varchar(100),@gra_name varchar(100),@stno varchar(100),@pk INT,@degree INT
DECLARE mycursor CURSOR FOR
select gra_school=rtrim(gra_school),gra_majo=rtrim(gra_majo),gra_name,stno from school.dbo.consultation where len(gra_school)>0 and len(gra_majo)>0 and len(gra_name)>0
OPEN mycursor 

--�N�Ĥ@����ƶ�J�ܼ�
FETCH NEXT FROM mycursor INTO @gra_school,@gra_majo,@gra_name,@stno
 WHILE @@FETCH_STATUS = 0  
 BEGIN       
       PRINT @gra_school+'--'+@gra_majo+'--'+@gra_name+'--'+@stno       
       
       INSERT INTO COM_MySchools(NAME,department,degree,status,lastModifiedDate,lastModifiedUser,createdDate,createdUser)VALUES
       (@gra_school,@gra_majo, CASE WHEN @gra_name='1' THEN 14 WHEN @gra_name='2' THEN 15 WHEN @gra_name='3' THEN 16 END,5,GETDATE(),'system',GETDATE(),'system')
       SELECT @pk=IDENT_CURRENT('COM_MySchools') 
       INSERT INTO COM_MemberMySchools(memberId,mySchoolsId,IDX)VALUES(@stno,@pk,1)    
       
FETCH NEXT FROM mycursor  INTO @gra_school,@gra_majo,@gra_name,@stno
END 
CLOSE mycursor
DEALLOCATE mycursor 
*/

/*********�u�@���**********/
20	1	member.identity	NULL	�@���
21	2	member.identity	NULL	����

INSERT INTO COM_AppProperty(seqNo,kind,valueTw)VALUES
(7,'alumni.status','')

  SELECT * FROM COM_AppProperty WHERE kind='alumni.status'

  SELECT * FROM COM_Member WHERE ID='29324006'
  
  update COM_Member set department=null,departmentName=null
  
INSERT INTO COM_Department(id,name,ename)
SELECT id,name,ename=isNull(esname,name) FROM EIP.dbo.COM_Unit where id NOT IN(
 SELECT id FROM COM_Department
)
  
SELECT * FROM COM_Department
  
SELECT *
FROM EIP.dbo.bridge_student S,EIP.dbo.COM_Unit u
WHERE S.�t��=u.id AND
�Ǹ�='29324006'

ALTER TABLE COM_Member 
ALTER COLUMN idNo nvarchar(100)


/**********�P�B���***********/
INSERT INTO COM_Department(id,name,ename)
SELECT id,name,ename=isNull(esname,name) FROM EIP.dbo.COM_Unit where id NOT IN(
 SELECT id FROM COM_Department
)

/*********�P�B�H��**********/
INSERT INTO COM_Member(id,rgno,cname,idNo,password,ename,sex,ident,departmentName,department,status,zip,address,cellphone,phone,blogUrl,email,otherEmail1,majorSubject)
SELECT id=�Ǹ�,rgno=�Ǹ�,cname=����m�W,idNo=�����Ҧr��,password=left(�����Ҧr��,4),ename=�^��m�W,sex=CASE WHEN �ʧO='M' THEN 1 ELSE 2 END,
ident=CASE WHEN ���ͧ_<>'' THEN 20 ELSE 21 END 
,departmentName=u.name,department=u.id,
status=CASE 
WHEN ���y���A IN(0,1,2,3,4,5) THEN 1  
WHEN ���y���A IN(20) THEN 2  
WHEN ���y���A IN(21) THEN 55
WHEN ���y���A IN(52) THEN 5
ELSE 56
END
,zip=�q�T�l���ϸ�,address=�q�T�a�},cellphone=��ʹq��,phone=�q�T�q��,blogUrl='',email=�q�l�l��H�c,otherEmail1='',majorSubject=''
 FROM EIP.dbo.bridge_student S,COM_Department u WHERE S.�t��=u.id AND �Ǹ� NOT IN(
  SELECT id FROM COM_Member
)

SELECT * FROM COM_AppProperty
  
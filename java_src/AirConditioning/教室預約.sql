select * from test

select * from RESERVE_ClassTime where weekend=0
and downloadBeginTime='1350'

7

dbo.RESERVE_Course

select * from RESERVE_ClassInfo
select * from RESERVE_ClassInfoStudents

select M.NAME from [140.129.140.205].SCHDB.DBO.SCH_SCO_SBJ_MST S LEFT OUTER JOIN [140.129.140.205].SCHDB.DBO.PSL_STA_MST M
ON S.STAFF_ID=M.STA_NO
where s_year=99 and s_sem=2 and op_no='412115'

--205§œ√“
select 
TEACHER=(
   select M.NAME from [140.129.140.205].SCHDB.DBO.SCH_SCO_SBJ_MST S LEFT OUTER JOIN [140.129.140.205].SCHDB.DBO.PSL_STA_MST M
   ON S.STAFF_ID=M.STA_NO where s_year=99 and s_sem=2 and op_no=T.OP_NO
)
,T.ROOM_NO,* from [140.129.140.205].SCHDB.DBO.SCH_SCO_SBJ_TIME T
where s_year=99 and s_sem=2 and t_day='§≠' and t_7=1
and room_no in(
 SELECT SNAME FROM POWER_Reader
)

SELECT * FROM  [140.129.140.205].SCHDB.DBO.SCH_SCO_MST 
WHERE S_YEAR=99 AND S_SEM=2 AND





select c.name,teacher=(select name from com_member where id=i.teacher)
,students=(select count(*) from RESERVE_ClassInfoStudents where classInfoId=i.id)
,i.openNo
from RESERVE_ClassInfo i,RESERVE_Course c
where 
c.id=i.course 
and week=6 and time7='1'

select * from RESERVE_QuartzRec

select * from RESERVE_QuartzRecStudents where 

delete RESERVE_QuartzRecStudents
delete RESERVE_QuartzRec


E1001-1

select * from POWER_Reader where id=80

select * from dbo.POWER_SpaceReader

select * from POWER_Reader where name like'%E%'

update POWER_Reader set name=replace(name,'A','E')


update POWER_Reader set name='E0001-1'
where id=80


select e.name,* from RESERVE_ClassInfo c,RESERVE_Course e
where 
c.Course=e.Course and
week=6 and time1=1 and enabled=1

update RESERVE_ClassInfo set classtime=24
where week=7 and time6=1 and enabled=1


select * from RESERVE_ClassTime where weekend=7



E10042





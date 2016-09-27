SELECT * from POWER_PowerControllerReader c,POWER_Reader r,G50 g
where c.readerId=r.id AND 
c.powerControllerId=g.controller AND r.readerId=g.reader

UPDATE r SET 
r.temp=g.settemp,
r.drive=CASE WHEN g.drive='ON' THEN 29 ELSE 30 END,
r.mode=
CASE 
WHEN g.mode='COOL' THEN 31 
WHEN g.mode='FAN' THEN 33 
WHEN g.mode='LC_AUTO' THEN 43 
END,
r.driveItem=CASE WHEN g.driveItem='CHK_OFF' THEN 35 ELSE 36 END,
r.modeItem=CASE WHEN g.modeItem='CHK_OFF' THEN 37 ELSE 38 END,
r.tempItem=CASE WHEN g.settempItem='CHK_OFF' THEN 39 ELSE 40 END,
r.filterItem=CASE WHEN g.filterItem='CHK_OFF' THEN 41 ELSE 42 END

from POWER_PowerControllerReader c,POWER_Reader r,G50 g
where c.readerId=r.id AND 
c.powerControllerId=g.controller AND r.readerId=g.reader


SELECT * FROM POWER_Reader

SELECT * FROM COM_AppProperty where kind='reader.filterItem'


SELECT * from G50

INSERT INTO G50(controller,reader,settemp,drive,mode,driveItem,modeItem,setTempItem,filterItem)
VALUES(1,25,1,1,1,1,1,1,1,1)

SELECT * FROM POWER_PowerController



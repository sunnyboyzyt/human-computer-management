USE [db_DoctorSystem]
GO
/****** Object:  Table [dbo].[T_Answer]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Answer](
	[answerid] [int] IDENTITY(1,1) NOT NULL,
	[answer] [varchar](50) NULL,
	[answeritemid] [int] NULL,
	[userid] [int] NULL,
	[examinationid] [int] NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_Answer] PRIMARY KEY CLUSTERED 
(
	[answerid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_AnswerKey]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_AnswerKey](
	[akeyid] [int] IDENTITY(1,1) NOT NULL,
	[akey] [varchar](50) NULL,
	[akeyname] [varchar](50) NULL,
	[itemid] [int] NOT NULL,
 CONSTRAINT [PK_T_AnswerKey] PRIMARY KEY CLUSTERED 
(
	[akeyid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Chart]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Chart](
	[chartid] [int] IDENTITY(1,1) NOT NULL,
	[chartname] [varchar](50) NULL,
	[photoid] [int] NULL,
	[description] [text] NULL,
 CONSTRAINT [PK_T_Chart] PRIMARY KEY CLUSTERED 
(
	[chartid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_ChiefComplaint]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_ChiefComplaint](
	[chiefComplaintid] [int] IDENTITY(1,1) NOT NULL,
	[symptom] [varchar](50) NULL,
	[nature] [varchar](50) NULL,
	[degree] [varchar](50) NULL,
	[continueddate] [varchar](50) NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_ChiefComplaint] PRIMARY KEY CLUSTERED 
(
	[chiefComplaintid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Class]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Class](
	[classid] [int] IDENTITY(1,1) NOT NULL,
	[classname] [varchar](50) NULL,
	[grade] [varchar](50) NULL,
 CONSTRAINT [PK_Table_1_1] PRIMARY KEY CLUSTERED 
(
	[classid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_EasyExamine]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_EasyExamine](
	[easyexamineid] [int] IDENTITY(1,1) NOT NULL,
	[easyexamineitem] [varchar](50) NULL,
	[easyexamineparam] [varchar](50) NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_EasyExamine] PRIMARY KEY CLUSTERED 
(
	[easyexamineid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Eexam]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Eexam](
	[examid] [int] IDENTITY(1,1) NOT NULL,
	[userid] [int] NOT NULL,
	[examtimeid] [int] NOT NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_exam] PRIMARY KEY CLUSTERED 
(
	[examid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_ExamTime]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_ExamTime](
	[examtimeid] [int] IDENTITY(1,1) NOT NULL,
	[examtimename] [varchar](50) NULL,
	[begindate] [datetime] NULL,
	[enddate] [datetime] NULL,
	[unitid] [int] NOT NULL,
 CONSTRAINT [PK_T_ExamTime] PRIMARY KEY CLUSTERED 
(
	[examtimeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Knowledge]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Knowledge](
	[knowledgeid] [int] IDENTITY(1,1) NOT NULL,
	[knowledgecontent] [text] NULL,
 CONSTRAINT [PK_T_Knowledge] PRIMARY KEY CLUSTERED 
(
	[knowledgeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_Life]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Life](
	[lifeid] [int] IDENTITY(1,1) NOT NULL,
	[diet] [varchar](50) NULL,
	[excretion] [varchar](50) NULL,
	[sleep] [varchar](50) NULL,
	[activity] [varchar](50) NULL,
	[useself] [varchar](50) NULL,
	[hobby] [varchar](50) NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_Life] PRIMARY KEY CLUSTERED 
(
	[lifeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_MentalSociety]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_MentalSociety](
	[mentalsocietyid] [int] IDENTITY(1,1) NOT NULL,
	[self] [text] NULL,
	[knowability] [text] NULL,
	[mood] [text] NULL,
	[sickknow] [text] NULL,
	[stress] [text] NULL,
	[belief] [text] NULL,
	[career] [text] NULL,
	[environment] [text] NULL,
	[familyrelationship] [text] NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_MentalSociety] PRIMARY KEY CLUSTERED 
(
	[mentalsocietyid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_NowSick]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_NowSick](
	[nowsicktid] [int] IDENTITY(1,1) NOT NULL,
	[sicksituation] [varchar](50) NULL,
	[sickdate] [datetime] NULL,
	[cause] [varchar](50) NULL,
	[mainsymptom] [varchar](50) NULL,
	[othersymptom] [varchar](50) NULL,
	[sickchange] [varchar](50) NULL,
	[helpprocess] [varchar](50) NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_NowSick] PRIMARY KEY CLUSTERED 
(
	[nowsicktid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_OtherExamine]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_OtherExamine](
	[otherexamineid] [int] IDENTITY(1,1) NOT NULL,
	[otherexamineitem] [varchar](50) NULL,
	[otherexamineparam] [varchar](50) NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_OtherExamine] PRIMARY KEY CLUSTERED 
(
	[otherexamineid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_PastSick]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_PastSick](
	[pastsickid] [int] IDENTITY(1,1) NOT NULL,
	[pasthealth] [text] NULL,
	[date] [datetime] NULL,
	[realization] [text] NULL,
	[medical] [text] NULL,
	[returnsituation] [text] NULL,
	[istrauma] [text] NULL,
	[issurgery] [text] NULL,
	[hospital] [text] NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_PastSick] PRIMARY KEY CLUSTERED 
(
	[pastsickid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_Patient]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Patient](
	[patientid] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[gender] [varchar](50) NULL,
	[age] [int] NULL,
	[job] [varchar](50) NULL,
	[nationality] [varchar](50) NULL,
	[birthplace] [varchar](50) NULL,
	[marriage] [varchar](50) NULL,
	[culture] [varchar](50) NULL,
	[faith] [varchar](50) NULL,
	[addr] [varchar](50) NULL,
	[phone] [varchar](11) NULL,
	[joindate] [datetime] NULL,
	[unitid] [int] NOT NULL,
 CONSTRAINT [PK_T_Patient] PRIMARY KEY CLUSTERED 
(
	[patientid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Personal]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Personal](
	[personalid] [int] IDENTITY(1,1) NOT NULL,
	[grow] [text] NULL,
	[menses] [text] NULL,
	[fertility] [text] NULL,
	[family] [text] NULL,
	[patientid] [int] NOT NULL,
 CONSTRAINT [PK_T_Personal] PRIMARY KEY CLUSTERED 
(
	[personalid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_Photo]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Photo](
	[photoid] [int] IDENTITY(1,1) NOT NULL,
	[photopath] [varchar](50) NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_T_Photo] PRIMARY KEY CLUSTERED 
(
	[photoid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_QuestionKey]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_QuestionKey](
	[qkeyid] [int] IDENTITY(1,1) NOT NULL,
	[qkey] [varchar](50) NULL,
	[qkeyname] [varchar](50) NULL,
	[itemid] [int] NOT NULL,
 CONSTRAINT [PK_T_QuestionKey] PRIMARY KEY CLUSTERED 
(
	[qkeyid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_QuestionType]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_QuestionType](
	[itemid] [int] IDENTITY(1,1) NOT NULL,
	[itemname] [varchar](50) NULL,
 CONSTRAINT [PK_T_QuestionType] PRIMARY KEY CLUSTERED 
(
	[itemid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Role]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Role](
	[roleid] [int] IDENTITY(1,1) NOT NULL,
	[rolename] [varchar](50) NULL,
	[roledescription] [varchar](50) NULL,
 CONSTRAINT [PK_T_Role] PRIMARY KEY CLUSTERED 
(
	[roleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Score]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Score](
	[scoreid] [int] IDENTITY(1,1) NOT NULL,
	[examid] [int] NOT NULL,
	[userid] [int] NOT NULL,
	[score1] [float] NOT NULL,
	[score2] [float] NOT NULL,
	[score3] [float] NOT NULL,
	[score4] [float] NOT NULL,
	[allscore] [float] NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[scoreid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_ScoreScale]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_ScoreScale](
	[scorescaleid] [int] IDENTITY(1,1) NOT NULL,
	[scorescalename] [varchar](50) NULL,
	[scorescale] [float] NOT NULL,
 CONSTRAINT [PK_T_ScoreScale] PRIMARY KEY CLUSTERED 
(
	[scorescaleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_SickInformation]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_SickInformation](
	[informationid] [int] IDENTITY(1,1) NOT NULL,
	[content1] [text] NULL,
	[content2] [text] NULL,
 CONSTRAINT [PK_T_SickInformation] PRIMARY KEY CLUSTERED 
(
	[informationid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[T_SickType]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_SickType](
	[sicktypeid] [int] IDENTITY(1,1) NOT NULL,
	[sicktypename] [varchar](50) NULL,
 CONSTRAINT [PK_T_SickType] PRIMARY KEY CLUSTERED 
(
	[sicktypeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_Unit]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_Unit](
	[unitid] [int] IDENTITY(1,1) NOT NULL,
	[unitcode] [varchar](50) NULL,
	[unitname] [varchar](50) NULL,
 CONSTRAINT [PK_T_Unit] PRIMARY KEY CLUSTERED 
(
	[unitid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_User]    Script Date: 2019/10/22 11:05:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_User](
	[userid] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[gender] [varchar](50) NULL,
	[pwd] [varchar](50) NULL,
	[phone] [varchar](50) NULL,
	[classid] [int] NOT NULL,
	[roleid] [int] NOT NULL,
	[isdelete] [int] NOT NULL,
	[remarks] [text] NULL,
	[photoid] [int] NOT NULL,
 CONSTRAINT [PK_T_User] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[T_ChiefComplaint] ON 

INSERT [dbo].[T_ChiefComplaint] ([chiefComplaintid], [symptom], [nature], [degree], [continueddate], [patientid]) VALUES (1, N'1', N'1', N'1', N'1', 1)
INSERT [dbo].[T_ChiefComplaint] ([chiefComplaintid], [symptom], [nature], [degree], [continueddate], [patientid]) VALUES (2, N'3', N'3', N'3', N'3', 3)
INSERT [dbo].[T_ChiefComplaint] ([chiefComplaintid], [symptom], [nature], [degree], [continueddate], [patientid]) VALUES (3, N'4', N'4', N'4', N'4', 4)
INSERT [dbo].[T_ChiefComplaint] ([chiefComplaintid], [symptom], [nature], [degree], [continueddate], [patientid]) VALUES (4, N'4', N'4', N'4', N'4', 4)
SET IDENTITY_INSERT [dbo].[T_ChiefComplaint] OFF
SET IDENTITY_INSERT [dbo].[T_Life] ON 

INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (1, N'1', N'1', N'1', N'1', N'1', N'1', 1)
INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (2, N'2', N'2', N'2', N'2', N'2', N'2', 2)
INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (3, N'1', N'1', N'1', N'1', N'1', N'1', 1)
INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (4, N'3', N'3', N'3', N'3', N'3', N'3', 3)
INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (5, N'4', N'4', N'4', N'4', N'4', N'4', 4)
INSERT [dbo].[T_Life] ([lifeid], [diet], [excretion], [sleep], [activity], [useself], [hobby], [patientid]) VALUES (6, N'23', N'33', N'3', N'3', N'3', N'3', 3)
SET IDENTITY_INSERT [dbo].[T_Life] OFF
SET IDENTITY_INSERT [dbo].[T_NowSick] ON 

INSERT [dbo].[T_NowSick] ([nowsicktid], [sicksituation], [sickdate], [cause], [mainsymptom], [othersymptom], [sickchange], [helpprocess], [patientid]) VALUES (1, N'头疼', CAST(0x0000AAEE00000000 AS DateTime), N'昨天晚上吃了酒', N'点疼', N'12', N'12', N'12', 1)
SET IDENTITY_INSERT [dbo].[T_NowSick] OFF
SET IDENTITY_INSERT [dbo].[T_Patient] ON 

INSERT [dbo].[T_Patient] ([patientid], [name], [gender], [age], [job], [nationality], [birthplace], [marriage], [culture], [faith], [addr], [phone], [joindate], [unitid]) VALUES (3, N'张三', N'男', 18, N'学生', N'汉', N'云南昆明', N'否', N'高中', N'无', N'云南昆明', N'15969347781', CAST(0x0000AA4500000000 AS DateTime), 1)
INSERT [dbo].[T_Patient] ([patientid], [name], [gender], [age], [job], [nationality], [birthplace], [marriage], [culture], [faith], [addr], [phone], [joindate], [unitid]) VALUES (8, N'3', N'3', 3, N'3', N'3', N'3', N'3', N'3', N'3', N'3', N'12345611111', CAST(0x00009CF100000000 AS DateTime), 2)
INSERT [dbo].[T_Patient] ([patientid], [name], [gender], [age], [job], [nationality], [birthplace], [marriage], [culture], [faith], [addr], [phone], [joindate], [unitid]) VALUES (9, N'4', N'4', 4, N'4', N'4', N'4', N'4', N'44444', N'4', N'4', N'12325256352', CAST(0x00009FCB00000000 AS DateTime), 3)
INSERT [dbo].[T_Patient] ([patientid], [name], [gender], [age], [job], [nationality], [birthplace], [marriage], [culture], [faith], [addr], [phone], [joindate], [unitid]) VALUES (10, N'1', N'1', 1, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'15222222222', CAST(0x000095CF00000000 AS DateTime), 5)
SET IDENTITY_INSERT [dbo].[T_Patient] OFF
INSERT [dbo].[T_User] ([userid], [name], [gender], [pwd], [phone], [classid], [roleid], [isdelete], [remarks], [photoid]) VALUES (1001, N'123456', N'1', N'77aa8b39208e6da481e96a7d797d3cc5', N'1', 1, 1, 1, N'1', 1)

Create table Students(
StudentID int primary key,
[Name] nvarchar(50),
[Address] nvarchar(200),
Gender char(1)
)

Create table Teachers(
TeacherID int primary key,
[Name] nvarchar(50),
Addresss nvarchar(200),
Gender char(1)
)

Create table Classes(
ClassID int primary key,
GroupID char(6),
courseID char(6),
NoCredits int,
Semester char(10),
[year] int,
StudentID int foreign key references Students(StudentID),
TeacherID int foreign key references Teachers(TeacherID)
)

Create table Attend(
Slot int primary key,
[Date] date,
Attend bit,
StudentID int foreign key references Students(StudentID)
)



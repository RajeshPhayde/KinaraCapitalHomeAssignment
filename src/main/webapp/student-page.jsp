
<html>
<head>
    <title>Student Details</title>
    <style>
        body{
            width: 100vw;
            height: 100vh;
            text-align: center;
            background: linear-gradient(135deg, rgb(141, 134, 134), white);
        }

        table{
            border: 1px solid crimson;
            text-align: center;
            margin-inline: auto;
            width: 30%;
        }
        th{
            border: 1px solid crimson;
            padding: 4px ;
        }
        td{
            padding: 4px;
        }
        a{
            margin: 10px;
            text-decoration: none;
            font-size: large;
            transition: 0.5s;
        }
        a:hover{
            transform: scale(2);
            transition: 0.5s;
        }
        h1{
            color: rgb(99, 7, 136);
        }
        h3{
            color: rgb(140, 20, 220);
        }

    </style>
</head>
<body>
    <h1>Student Details</h1>
    <table>
        
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Total Marks</th>
        </tr>
        <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${totalMarks}</td>
        </tr>
       
    </table>
    <br>
    <h3>${message}</h3>
    <br>
    <h3>page no : ${currentPage}</h3>
    <div>
        <a href="?page=${currentPage - 1}">Previous</a>
        <a href="?page=${currentPage + 1}">Next</a>
    </div>
</body>
</html>
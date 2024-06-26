use ejercicio02;

db.createCollection('departamentos');

db.departamentos.insertMany([
    {
    "codigo": 1,
    "nombre": "Marketing",
    "presupuesto": 60000,
    },
    {
    "codigo": 2,
    "nombre": "Informatica",
    "presupuesto": 75500,
    },
    {
    "codigo": 3,
    "nombre": "Construccion",
    "presupuesto": 100000,
    }
]);

db.createCollection('empleados');

db.empleados.insertMany([
    {
        "DNI": "11111111",
        "nombre": "Juan Manuel",
        "apellidos": "Magan",
        "departamentos": 1,
    },
    {
        "DNI": "22222222",
        "nombre": "Mario",
        "apellidos": "Vaquerizo",
        "departamentos": 3,
    },
    {
        "DNI": "33333333",
        "nombre": "Figero",
        "apellidos": "Almibar",
        "departamentos": 2,
    },
    {
        "DNI": "25252525",
        "nombre": "Pedro",
        "apellidos": "Ruibal",
        "departamentos": 2,
    },
    {
        "DNI": "38383838",
        "nombre": "Javier",
        "apellidos": "Santaolalla",
        "departamentos": 1,
    },
    {
        "DNI": "41414141",
        "nombre": "Francisco",
        "apellidos": "Bahamonde",
        "departamentos": 3,
    },
]);
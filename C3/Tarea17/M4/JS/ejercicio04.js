use ejercicio04;

db.createCollection('salas');

db.salas.insertMany([
    {
        "codigo": 1,
        "nombre": "Sala A",
        "pelicula": 101,
    },
    {
        "codigo": 2,
        "nombre": "Sala B",
        "pelicula": 103,
    },
    {
        "codigo": 3,
        "nombre": "Sala C",
        "pelicula": 105,
    }
]);

db.createCollection('peliculas');

db.peliculas.insertMany([
    {
        "codigo": 101,
        "nombre": "The Godfather",
        "clasificacionEdad": "18"
    },
    {
        "codigo": 102,
        "nombre": "Forrest Gump",
        "clasificacionEdad": "13"
    },
    {
        "codigo": 103,
        "nombre": "The Dark Knight",
        "clasificacionEdad": "13"
    },
    {
        "codigo": 104,
        "nombre": "Schindler's List",
        "clasificacionEdad": "18"
    },
    {
        "codigo": 105,
        "nombre": "Fight Club",
        "clasificacionEdad": "18"
    },
    {
        "codigo": 106,
        "nombre": "The Matrix",
        "clasificacionEdad": "18"
    }
]);
const mongoose = require("mongoose");

mongoose
  .connect("mongodb://localhost/movies", { useNewUrlParser: true,useUnifiedTopology: true })
  .then(() => console.log("connected to MongoDB"))
  .catch((err) => console.log("Error", err));

const moviesSchema = new mongoose.Schema({
  name: { type: String, required: true, minlength: 3, maxlength: 255 },
  imdb: String,
  tags: {
    type: Array,
    validate: {
      isAsync: true,
      validator: function (v, callback) {
        setTimeout(() => {
          const result = v && v.length > 3;
          callback(result);
        }, 3000);
      },
      message: "A movie must have a tag",
    },
  },
  date: { type: Date, default: Date.now },
  isPublished: Boolean,
});

const Movies = mongoose.model("Movies", moviesSchema);

/**
 * In order to add movies
 */

async function addMovies() {
  const movies = new Movies({
    name: "The curious case of Benjamin Button",
    imdb: "9.2",
    tags: "",
    isPublished: true,
  });
  try {
    const result = await movies.save();
    console.log(result);
  } catch (error) {
    console.log("error", error);
  }
}

addMovies();

/**
 * In order to retrive movies
 *
 * .find({marks:{$gte: 10, $lte:20}}) gte means greater than equals
 * .find({marks: {$in: [100,150, 2000]}}) in order to include 100 or 150 or 2000
 *
 * For logical operators
 *
 *  .or/and([{name:'Inception'}, {isPublished:true}])
 *
 * for regex
 * .find({name: /^Ince}) starts with
 * .find({name: /ion$/i}) ends with i makes it case insensative
 * .find({name:. /.*ion.* /}) in the middle
 */

// async function findMovies() {
//   const movies = await Movies.find({ tags: "Thriller" }).sort({name:1}).catch((err) => {
//     console.log("Error", err);
//   });
//   console.log(movies);
// }

// findMovies();

/**
 * To update movie
 * We have two approach
 * 1. Query first approach
 * 2. Update First approach
 */

// async function updateMovie(id) {
//   const movie = await Movies.findById(id);
//   if (!movie) {
//     return;
//   }
//   movie.set({
//     name: "Martian",
//     isPublished: true,
//   });

//  const result =  await movie.save();
//  console.log(result);
// }

// updateMovie('5edba275b1571b293060022e');

// async function updateMovie(id) {
//   const result = await Movies.update(
//     { _id: id },
//     {
//       $set: {
//         name: "Interesteller",
//         isPublished: false,
//       },
//     }
//   );
//   console.log(result);
// }

// updateMovie("5edba275b1571b293060022e");

// async function deleteMovie(id){
//   const result=  await Movies.deleteOne({_id:id}); // to delete many use deleteMany
//   console.log(result);

//  }

//  deleteMovie('5edba275b1571b293060022e');

window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_student_form');
    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.querySelector('#odontologo_id').value;

        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,

        };

        const url = '/odontologos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/odontologos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let student = data;
              document.querySelector('#odontologo_id').value = student.id;
              document.querySelector('#nombre').value = student.name;
              document.querySelector('#apellido').value = student.lastname;

              document.querySelector('#div_odontologo_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }
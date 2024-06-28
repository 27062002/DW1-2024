var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
  return new bootstrap.Tooltip(tooltipTriggerEl)
});

var myModal = document.getElementById('myModal');
myModal.addEventListener('show.bs.modal', function (event) {
  // Botão que acionou o modal
  var button = event.relatedTarget;
  // Extrair informações dos atributos data-bs-*
  var id = button.getAttribute('data-bs-id');

  // Atualizar o conteúdo do modal
  var modalTitle = myModal.querySelector('.modal-title')
  var modalFooterA = myModal.querySelector('.modal-footer a')

  modalTitle.textContent = 'Exclusão da Atividade ' + id;
  modalFooterA.href = 'ControllerServlet?action=deleteActivity&activity-id=' + id;
})

const btnAddItem = document.getElementById('btn-add-item');
const modalAddItem = document.getElementById('modal-add-item');
const btnReset = document.getElementById('btn-reset');
const formAddItem = document.getElementById('form-add-item');
const url = 'http://localhost:1001/api/v1/itens';

btnAddItem.addEventListener('click', () => {
  modalAddItem.style.display = 'flex';
});

btnReset.addEventListener('click', () => {
  modalAddItem.style.display = 'none';
});

function formatPrice(price) {
  return price.replace('.', '').replace(',', '.');
}

function getType(e) {
  if (e.target.unit.checked) {
    return 'unit';
  }

  if (e.target.kg.checked) {
    return 'kg';
  }

  if (!e.target.unit.checked && !e.target.kg.checked) {
    return false;
  }
}

function addItem(item) {
  fetch (url, {
    headers: {
      'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify(item)
  })
  .then(response => response.text())
  .then(response => console.log(response));
}

formAddItem.addEventListener('submit', e => {
  e.preventDefault();

  const item = Object.create(null);
  item.item = e.target.item.value.trim();
  item.brand = e.target.brand.value.trim();
  item.local = e.target.local.value.trim();
  item.price = Number(formatPrice(e.target.price.value.trim()));
  item.type = getType(e);

  if (item.type) {
    addItem(item);
    formAddItem.reset();
    modalAddItem.style.display = 'none';
  } else {
    alert('Selecione se "Unidade" ou "Kg"');
  }
});
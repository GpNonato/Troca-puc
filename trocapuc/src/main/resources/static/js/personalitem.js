
function openCreateModal() {
    const modal = document.querySelector('.createmodal');
    modal.style.display = 'block'; 
}


function closeCreateModal() {
    const modal = document.querySelector('.createmodal');
    modal.style.display = 'none'; 
}


window.addEventListener('click', function (event) {
    const modal = document.querySelector('.createmodal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
});

function togglePriceField() {
    const category = document.getElementById("category").value;
    const priceField = document.getElementById("price-field");

    if (category === "sell") {
        priceField.style.display = "block";
    } else {
        priceField.style.display = "none";
        document.getElementById("price").value = "";
    }
}


function confirmDelete() {
    return confirm("Tem certeza de que deseja deletar este item?");
}
function openEditModal(itemId) {
    const editModal = document.querySelector('.editmodal');

    // Encontre o elemento do card com base no data-id
    const card = document.querySelector(`.card[data-id="${itemId}"]`);
    if (!card) {
        console.error(`Card with data-id "${itemId}" not found.`);
        return;
    }

    // Extraia as informações do card
    const name = card.querySelector('h3 span').textContent;
    const description = card.querySelector('p:nth-of-type(1) span').textContent;
    const category = card.querySelector('p:nth-of-type(2) span').textContent.toLowerCase();
    const type = card.querySelector('p:nth-of-type(3) span').textContent.toLowerCase();
    const price = card.querySelector('p:nth-of-type(4) span')?.textContent || null;

    // Preencha os campos do modal de edição
    editModal.querySelector('input[name="id"]').value = itemId;
    editModal.querySelector('input[name="name"]').value = name;
    editModal.querySelector('input[name="description"]').value = description;
    editModal.querySelector('select[name="category"]').value = category;
    editModal.querySelector('select[name="type"]').value = type;

    const priceField = editModal.querySelector('#price-field');
    const priceInput = editModal.querySelector('input[name="price"]');
    if (category === 'sell') {
        priceField.style.display = 'block';
        priceInput.value = price;
    } else {
        priceField.style.display = 'none';
        priceInput.value = '';
    }

    // Adicione um listener para o campo de categoria dentro do modal
    const categorySelect = editModal.querySelector('select[name="category"]');
    categorySelect.addEventListener('change', () => {
        if (categorySelect.value === 'sell') {
            priceField.style.display = 'block';
        } else {
            priceField.style.display = 'none';
            priceInput.value = '';
        }
    });

    // Exiba o modal de edição
    editModal.style.display = 'block';
}



function closeEditModal() {
    const editModal = document.querySelector('.editmodal');
    editModal.style.display = 'none';
}


window.addEventListener('click', function (event) {
    const editModal = document.querySelector('.editmodal');
    if (event.target === editModal) {
        closeEditModal();
    }
});
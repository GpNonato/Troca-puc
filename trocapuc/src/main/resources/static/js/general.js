document.addEventListener("DOMContentLoaded", () => {
    // Market Elements
    const marketLink = document.getElementById("market-a");
    const marketImg = document.getElementById("market-img");
    const marketChoice = document.querySelector(".market-choice");

    // Notification Elements
    const notificationLink = document.getElementById("notification-a");
    const notificationImg = document.getElementById("notification-img");
    const notificationChoice = document.querySelector(".notification-choice");

    // Toggle Market Menu
    marketLink.addEventListener("click", (event) => {
        event.preventDefault();

        const isMarketOpen = marketChoice.style.display === "flex";
        if (isMarketOpen) {
            marketChoice.style.display = "none";
            marketLink.classList.remove("open");
            marketImg.classList.remove("open");
        } else {
            closeAllMenus(); // Fecha outros menus
            marketChoice.style.display = "flex";
            marketLink.classList.add("open");
            marketImg.classList.add("open");
        }
    });

    // Toggle Notification Menu
    notificationLink.addEventListener("click", (event) => {
        event.preventDefault();

        const isNotificationOpen = notificationChoice.style.display === "flex";
        if (isNotificationOpen) {
            notificationChoice.style.display = "none";
            notificationLink.classList.remove("open");
            notificationImg.classList.remove("open");
        } else {
            closeAllMenus(); // Fecha outros menus
            notificationChoice.style.display = "flex";
            notificationLink.classList.add("open");
            notificationImg.classList.add("open");
        }
    });

    // Close all menus
    function closeAllMenus() {
        // Close Market Menu
        marketChoice.style.display = "none";
        marketLink.classList.remove("open");
        marketImg.classList.remove("open");

        // Close Notification Menu
        notificationChoice.style.display = "none";
        notificationLink.classList.remove("open");
        notificationImg.classList.remove("open");
    }

    // Close menus when clicking outside
    document.addEventListener("click", (event) => {
        if (!marketLink.contains(event.target) && !marketChoice.contains(event.target)) {
            marketChoice.style.display = "none";
            marketLink.classList.remove("open");
            marketImg.classList.remove("open");
        }

        if (!notificationLink.contains(event.target) && !notificationChoice.contains(event.target)) {
            notificationChoice.style.display = "none";
            notificationLink.classList.remove("open");
            notificationImg.classList.remove("open");
        }
    });
});


function openProposalModal(itemId, itemCategory) {
    console.log("Item ID:", itemId, "Category:", itemCategory);

    // Atualizar o campo oculto com o ID do item
    const itemIdField = document.getElementById("item-id");
    if (itemIdField) {
        itemIdField.value = itemId;
    }

    // Mostrar ou ocultar o campo de preço com base na categoria
    const priceField = document.getElementById("price-field");
    if (priceField) {
        priceField.style.display = itemCategory === "sell" ? "block" : "none";
    }

    // Exibir o modal
    document.querySelector(".proposalmodal").style.display = "block";
}





function closeProposalModal() {
    const modal = document.querySelector(".proposalmodal");
    if (modal) {
        modal.style.display = "none"; // Esconde o modal
    } else {
        console.error("Modal not found.");
    }
}

// Verifica se o formulário existe antes de adicionar o event listener
document.getElementById("proposal-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const itemId = document.getElementById("item-id").value;
    const description = document.getElementById("description").value;
    const priceField = document.getElementById("price");
    const price = priceField && priceField.value ? parseFloat(priceField.value) : null;

    if (!description || !itemId) {
        alert("Description and itemId are required.");
        return;
    }

    const payload = { itemId, description, price };

    try {
        const response = await fetch("/proposal", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(payload),
        });

        if (response.ok) {
            alert("Proposal sent successfully");
            closeProposalModal();
        } else {
            const error = await response.json();
            console.error("Error response:", error);
            alert("Error sending proposal: " + error.message);
        }
    } catch (error) {
        console.error("Unexpected error:", error);
        alert("An unexpected error occurred.");
    }
});

function filterProposalsReceived(status) {
    window.location.href = '/notification/received?status=' + status;
}
function filterProposalsSent(status) {
    window.location.href = '/notification/sent?status=' + status;
}
// Abrir um modal específico associado a um proposalId
function openNotificationModal(proposalId, modalId) {
    console.log(`Opening modal ${modalId} for proposal ID: ${proposalId}`);
    const modal = document.getElementById(`notificationmodalcard${modalId}`);
    if (modal) {
        modal.style.display = "block";
    }
}

// Fechar um modal específico
function closeNotificationModal(modalId) {
    const modal = document.getElementById(`notificationmodalcard${modalId}`);
    if (modal) {
        modal.style.display = "none";
    }
}

// Funções para alterar o status da proposta
function changeTradingStatus(proposalId) {
    updateProposalStatus(proposalId, "TRADING");
}

function changeRefuseStatus(proposalId) {
    updateProposalStatus(proposalId, "REFUSED");
}

function changeAcceptStatus(proposalId) {
    updateProposalStatus(proposalId, "ACCEPTED");
}

// Atualizar o status no backend
function updateProposalStatus(proposalId, status) {
    const url = `/proposal/${proposalId}/status?status=${status}`; // Corrigida a URL para "/proposal"
    console.log(`Sending POST request to: ${url}`);
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (response.ok) {
                alert("Status updated successfully");
                location.reload(); // Atualizar a página
            } else {
                alert("Failed to update status");
            }
        })
        .catch(error => {
            console.error("Error updating status:", error);
            alert("An error occurred");
        });
}

